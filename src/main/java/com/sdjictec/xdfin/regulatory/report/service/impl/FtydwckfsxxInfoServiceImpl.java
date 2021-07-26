package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwckfsxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import com.sdjictec.xdfin.regulatory.report.service.FtydwckfsxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 非同业单位存款发生额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwckfsxxInfoServiceImpl extends ServiceImpl<FtydwckfsxxInfoMapper, FtydwckfsxxInfo> implements FtydwckfsxxInfoService {
    @Autowired
    FtydwckjcxxInfoMapper ftydwckjcxxInfoMapper;
    @Autowired
    FtydwckyexxInfoMapper ftydwckyexxInfoMapper;
    @Autowired
    FtydwckfsxxInfoMapper ftydwckfsxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ckzhbm,String ckxh,String sjrq)  {
        if(StrUtil.isEmpty(khh)) {
            return false;
        }
        QueryWrapper<FtydwckjcxxInfo> queryWrapper1 = new QueryWrapper<FtydwckjcxxInfo>();
        queryWrapper1.eq("khh", khh);
        queryWrapper1.eq("ckzhbm",ckzhbm);
        queryWrapper1.eq("ckxh",ckxh);
//        queryWrapper1.eq("sjrq",sjrq);
        List<FtydwckjcxxInfo> list1 = ftydwckjcxxInfoMapper.selectList(queryWrapper1);
        boolean result1 = list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<FtydwckyexxInfo> queryWrapper2 = new QueryWrapper<FtydwckyexxInfo>();
        queryWrapper2.eq("khh", khh);
        queryWrapper1.eq("ckzhbm",ckzhbm);
        queryWrapper1.eq("ckxh",ckxh);
        queryWrapper1.eq("sjrq",sjrq);
        List<FtydwckyexxInfo> list2 = ftydwckyexxInfoMapper.selectList(queryWrapper2);
        boolean result2 = list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    @Override
    public void ftydwckfsxxInfoImport(String sjrq, String filePath) {
        List<FtydwckfsxxInfo> ftydwckfsxxInfoList = null;
        try {
            ftydwckfsxxInfoList = this.saxReadFtydwckfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckfsxxInfo ftydwckfsxxInfo : ftydwckfsxxInfoList) {
            if(!this.checkKhh(ftydwckfsxxInfo.getKhh(),ftydwckfsxxInfo.getCkzhbm(),ftydwckfsxxInfo.getCkxh(),sjrq)) {
                log.error("数据出现问题:{},{},{},{}",ftydwckfsxxInfo.getKhh(),ftydwckfsxxInfo.getCkzhbm(),ftydwckfsxxInfo.getCkxh(),sjrq);
                break;
            }
            ftydwckfsxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(ftydwckfsxxInfo.getJylsh())) {
                ftydwckfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            } else {
                ftydwckfsxxInfo.setJylsh(ftydwckfsxxInfo.getJylsh().trim());
            }
            ftydwckfsxxInfoMapper.insert(ftydwckfsxxInfo);
        }
    }

    //存款发生
    private static List<FtydwckfsxxInfo> saxReadFtydwckfsxxInfo(String pathFile) throws IOException {
        FtydwckfsxxInfoListener ftydwckfsxxInfoListener = new FtydwckfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckfsxxInfo.class, ftydwckfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckfsxxInfoListener.getFtydwckfsxxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<FtydwckfsxxInfo> queryWrapper = new QueryWrapper<FtydwckfsxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return ftydwckfsxxInfoMapper.delete(queryWrapper);
    }
}
