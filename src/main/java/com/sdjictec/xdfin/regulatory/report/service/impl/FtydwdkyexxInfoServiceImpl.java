package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkyexxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkyexxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwdkyexxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkyexxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkyexxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.FtydwdkyexxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 非同业单位贷款余额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwdkyexxInfoServiceImpl extends ServiceImpl<FtydwdkyexxInfoMapper, FtydwdkyexxInfo> implements FtydwdkyexxInfoService {

    @Autowired
    private FtydwdkjcxxFullInfoMapper ftydwdkjcxxFullInfoMapper;

    @Autowired
    private FtydwdkyexxFullInfoMapper ftydwdkyexxFullInfoMapper;

    @Autowired
    private FtydwdkyexxInfoMapper ftydwdkyexxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String dkjjbh) {
        if(StrUtil.isEmpty(khh) || StrUtil.isEmpty(dkjjbh)) {
            return false;
        }
        QueryWrapper<FtydwdkjcxxFullInfo> queryWrapper = new QueryWrapper<FtydwdkjcxxFullInfo>();
        queryWrapper.eq("khh", khh);
        queryWrapper.eq("dkjjbh",dkjjbh);
        List<FtydwdkjcxxFullInfo> list = ftydwdkjcxxFullInfoMapper.selectList(queryWrapper);
        return list.isEmpty() ? false : list.size()>0;
    }

    @Override
    public void ftydwdkjcxxInfoImport(String sjrq,String filePath) {
        List<FtydwdkyexxInfo> ftydwdkyexxInfoList = null;
        try {
            ftydwdkyexxInfoList = EasyXlsUtil.saxReadFtydwdkyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkyexxInfo ftydwdkyexxInfo : ftydwdkyexxInfoList) {
            if(!checkKhh(ftydwdkyexxInfo.getKhh(),ftydwdkyexxInfo.getDkjjbh())) {
                log.error("数据出现问题:{},{}",ftydwdkyexxInfo.getKhh(),ftydwdkyexxInfo.getDkjjbh());
            }
            ftydwdkyexxInfo.setSjrq(sjrq);
            QueryWrapper<FtydwdkyexxFullInfo> queryWrapper = new QueryWrapper<FtydwdkyexxFullInfo>();
            queryWrapper.eq("dkjjbh", ftydwdkyexxInfo.getDkjjbh());
            FtydwdkyexxFullInfo selectOne = ftydwdkyexxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                ftydwdkyexxInfoMapper.insert(ftydwdkyexxInfo);
                FtydwdkyexxFullInfo ftydwdkyexxFullInfo = new FtydwdkyexxFullInfo();
                BeanUtil.copyProperties(ftydwdkyexxInfo,ftydwdkyexxFullInfo,true);
                ftydwdkyexxFullInfoMapper.insert(ftydwdkyexxFullInfo);
            } else {
                if(!NumberUtil.toStr(selectOne.getDkye()).equals(NumberUtil.toStr(ftydwdkyexxInfo.getDkye()))) {
                    ftydwdkyexxFullInfoMapper.delete(queryWrapper);
                    FtydwdkyexxFullInfo ftydwdkyexxFullInfo = new FtydwdkyexxFullInfo();
                    BeanUtil.copyProperties(ftydwdkyexxInfo,ftydwdkyexxFullInfo,true);
                    ftydwdkyexxFullInfoMapper.insert(ftydwdkyexxFullInfo);
                    ftydwdkyexxInfoMapper.insert(ftydwdkyexxInfo);
                }
            }
        }
    }

    //贷款余额
    public static List<FtydwdkyexxInfo> saxReadFtydwdkyexxInfo(String pathFile) throws IOException {
        FtydwdkyexxInfoListener ftydwdkyexxInfoListener = new FtydwdkyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkyexxInfo.class, ftydwdkyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkyexxInfoListener.getFtydwdkyexxInfoList();
    }
}
