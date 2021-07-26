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
import com.sdjictec.xdfin.regulatory.report.listener.TyckfsxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.listener.TyckjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.service.TyckjcxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 同业存款基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class TyckjcxxInfoServiceImpl extends ServiceImpl<TyckjcxxInfoMapper, TyckjcxxInfo> implements TyckjcxxInfoService {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    private TyckjcxxFullInfoMapper tyckjcxxFullInfoMapper;
    @Autowired
    private TyckjcxxInfoMapper tyckjcxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh) {
        if(StrUtil.isEmpty(khh)) {
            return false;
        }
        DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(khh);
        return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
    }

    @Override
    public void tyckjcxxInfoImport(String sjrq,String filePath) {
        List<TyckjcxxInfo> tyckjcxxInfoList = null;
        try {
            tyckjcxxInfoList = this.saxReadTyckjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckjcxxInfo tyckjcxxInfo : tyckjcxxInfoList) {
            if (!checkKhh(tyckjcxxInfo.getKhh())) {
                log.error("数据出现问题:{}",tyckjcxxInfo.getKhh());
                break;
            }
            tyckjcxxInfo.setSjrq(sjrq);
            QueryWrapper<TyckjcxxFullInfo> queryWrapper = new QueryWrapper<TyckjcxxFullInfo>();
            queryWrapper.eq("ckzhbm", tyckjcxxInfo.getCkzhbm());
            TyckjcxxFullInfo selectOne = tyckjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                tyckjcxxInfoMapper.insert(tyckjcxxInfo);
                TyckjcxxFullInfo tyckjcxxFullInfo = new TyckjcxxFullInfo();
                BeanUtil.copyProperties(tyckjcxxInfo,tyckjcxxFullInfo,true);
                tyckjcxxFullInfoMapper.insert(tyckjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getDqrq()) && !selectOne.getDqrq().equals(tyckjcxxInfo.getDqrq())) {
                    tyckjcxxFullInfoMapper.delete(queryWrapper);
                    TyckjcxxFullInfo tyckjcxxFullInfo = new TyckjcxxFullInfo();
                    BeanUtil.copyProperties(tyckjcxxInfo,tyckjcxxFullInfo,true);
                    tyckjcxxFullInfoMapper.insert(tyckjcxxFullInfo);
                    tyckjcxxInfoMapper.insert(tyckjcxxInfo);
                }
            }
        }
    }
    //同业存款基础
    public static List<TyckjcxxInfo> saxReadTyckjcxxInfo(String pathFile) throws IOException {
        TyckjcxxInfoListener tyckjcxxInfoListener = new TyckjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckjcxxInfo.class, tyckjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckjcxxInfoListener.getTyckjcxxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<TyckjcxxInfo> queryWrapper = new QueryWrapper<TyckjcxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return tyckjcxxInfoMapper.delete(queryWrapper);
    }
}
