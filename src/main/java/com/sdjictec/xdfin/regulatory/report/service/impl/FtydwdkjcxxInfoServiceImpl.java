package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwdkjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.service.FtydwdkjcxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 非同业单位贷款基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwdkjcxxInfoServiceImpl extends ServiceImpl<FtydwdkjcxxInfoMapper, FtydwdkjcxxInfo> implements FtydwdkjcxxInfoService {

    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    FtydwdkjcxxFullInfoMapper ftydwdkjcxxFullInfoMapper;
    @Autowired
    FtydwdkjcxxInfoMapper ftydwdkjcxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh) {
        if(StrUtil.isEmpty(khh)) {
            return false;
        }
        DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(khh);
        return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
    }

    @Override
    public void ftydwdkjcxxInfoImport(String sjrq, String filePath) {
        List<FtydwdkjcxxInfo> ftydwdkjcxxInfoList = null;
        try {
            ftydwdkjcxxInfoList = this.saxReadFtydwdkjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkjcxxInfo ftydwdkjcxxInfo : ftydwdkjcxxInfoList) {
            if(!checkKhh(ftydwdkjcxxInfo.getKhh())) {
                log.error("数据出现问题:{}",ftydwdkjcxxInfo.getKhh());
                break;
            }
            ftydwdkjcxxInfo.setSjrq(sjrq);
            QueryWrapper<FtydwdkjcxxFullInfo> queryWrapper = new QueryWrapper<FtydwdkjcxxFullInfo>();
            queryWrapper.eq("dkjjbh", ftydwdkjcxxInfo.getDkjjbh());
            FtydwdkjcxxFullInfo selectOne = ftydwdkjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                ftydwdkjcxxInfoMapper.insert(ftydwdkjcxxInfo);
                FtydwdkjcxxFullInfo ftydwdkjcxxFullInfo = new FtydwdkjcxxFullInfo();
                BeanUtil.copyProperties(ftydwdkjcxxInfo,ftydwdkjcxxFullInfo,true);
                ftydwdkjcxxFullInfoMapper.insert(ftydwdkjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getSjzzrq()) && !selectOne.getSjzzrq().equals(ftydwdkjcxxInfo.getSjzzrq())) {
                    ftydwdkjcxxFullInfoMapper.delete(queryWrapper);
                    FtydwdkjcxxFullInfo ftydwdkjcxxFullInfo = new FtydwdkjcxxFullInfo();
                    BeanUtil.copyProperties(ftydwdkjcxxInfo,ftydwdkjcxxFullInfo,true);
                    ftydwdkjcxxFullInfoMapper.insert(ftydwdkjcxxFullInfo);
                    ftydwdkjcxxInfoMapper.insert(ftydwdkjcxxInfo);
                }
            }
        }
    }

    //贷款基础
    public static List<FtydwdkjcxxInfo> saxReadFtydwdkjcxxInfo(String pathFile) throws IOException {
        FtydwdkjcxxInfoListener ftydwdkjcxxInfoListener = new FtydwdkjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkjcxxInfo.class, ftydwdkjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkjcxxInfoListener.getFtydwdkjcxxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<FtydwdkjcxxInfo> queryWrapper = new QueryWrapper<FtydwdkjcxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return ftydwdkjcxxInfoMapper.delete(queryWrapper);
    }
}
