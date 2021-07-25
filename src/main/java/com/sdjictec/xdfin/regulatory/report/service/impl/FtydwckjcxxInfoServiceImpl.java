package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwckjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwckjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.service.FtydwckjcxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  非同业单位存款基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwckjcxxInfoServiceImpl extends ServiceImpl<FtydwckjcxxInfoMapper, FtydwckjcxxInfo> implements FtydwckjcxxInfoService {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    FtydwckjcxxInfoMapper ftydwckjcxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh) {
        if(StrUtil.isEmpty(khh)) {
            return false;
        }
        DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(khh);
        return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
    }

    @Override
    public void ftydwckjcxxInfoImport(String sjrq,String filePath) {
        List<FtydwckjcxxInfo> ftydwckjcxxInfoList = null;
        try {
            ftydwckjcxxInfoList = this.saxReadFtydwckjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckjcxxInfo ftydwckjcxxInfo : ftydwckjcxxInfoList) {
            if(!this.checkKhh(ftydwckjcxxInfo.getKhh())) {
                log.error("数据出现问题:{}",ftydwckjcxxInfo.getKhh());
                break;
            }
            ftydwckjcxxInfo.setSjrq(sjrq);
            ftydwckjcxxInfoMapper.insert(ftydwckjcxxInfo);
        }
    }

    //存款基础
    public static List<FtydwckjcxxInfo> saxReadFtydwckjcxxInfo(String pathFile) throws IOException {
        FtydwckjcxxInfoListener ftydwckjcxxInfoListener = new FtydwckjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwckjcxxInfo.class, ftydwckjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwckjcxxInfoListener.getFtydwckjcxxInfoList();
    }
}
