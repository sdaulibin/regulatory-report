package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckfsxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckyexxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwckyexxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwckjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwckyexxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.FtydwckyexxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 非同业单位存款余额新表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwckyexxInfoServiceImpl extends ServiceImpl<FtydwckyexxInfoMapper, FtydwckyexxInfo> implements FtydwckyexxInfoService {
    @Autowired
    FtydwckjcxxInfoMapper ftydwckjcxxInfoMapper;
    @Autowired
    FtydwckyexxInfoMapper ftydwckyexxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ckzhbm,String ckxh,String sjrq)  {
        if(StrUtil.isEmpty(khh)) {
            return false;
        }
        QueryWrapper<FtydwckjcxxInfo> queryWrapper1 = new QueryWrapper<FtydwckjcxxInfo>();
        queryWrapper1.eq("khh", khh);
        queryWrapper1.eq("ckzhbm",ckzhbm);
        queryWrapper1.eq("ckxh",ckxh);
        //queryWrapper1.eq("sjrq",sjrq);
        List<FtydwckjcxxInfo> list1 = ftydwckjcxxInfoMapper.selectList(queryWrapper1);
        boolean result1 = list1.isEmpty() ? false : list1.size()>0;
        return result1;
    }

    @Override
    public void ftydwckyexxInfoImport(String sjrq,String filePath) {
        List<FtydwckyexxInfo> ftydwckyexxInfoList = null;
        try {
            ftydwckyexxInfoList = this.saxReadFtydwckyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckyexxInfo ftydwckyexxInfo : ftydwckyexxInfoList) {
            if(!checkKhh(ftydwckyexxInfo.getKhh(),ftydwckyexxInfo.getCkzhbm(),ftydwckyexxInfo.getCkxh(),sjrq)) {
                log.error("数据出现问题:{},{},{},{}",ftydwckyexxInfo.getKhh(),ftydwckyexxInfo.getCkzhbm(),ftydwckyexxInfo.getCkxh(),sjrq);
                break;
            };
            ftydwckyexxInfo.setSjrq(sjrq);
            ftydwckyexxInfoMapper.insert(ftydwckyexxInfo);
        }
    }
    //存款发生额
    public static List<FtydwckyexxInfo> saxReadFtydwckyexxInfo(String pathFile) throws IOException {
        FtydwckyexxInfoListener ftydwckyexxInfoListener = new FtydwckyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckyexxInfo.class, ftydwckyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckyexxInfoListener.getFtydwckyexxInfoList();
    }
    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<FtydwckyexxInfo> queryWrapper = new QueryWrapper<FtydwckyexxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return ftydwckyexxInfoMapper.delete(queryWrapper);
    }
}
