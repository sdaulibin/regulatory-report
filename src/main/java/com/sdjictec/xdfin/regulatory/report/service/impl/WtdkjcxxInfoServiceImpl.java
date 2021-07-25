package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.WtdkjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.service.WtdkjcxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 委托贷款基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class WtdkjcxxInfoServiceImpl extends ServiceImpl<WtdkjcxxInfoMapper, WtdkjcxxInfo> implements WtdkjcxxInfoService {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    private WtdkjcxxFullInfoMapper wtdkjcxxFullInfoMapper;
    @Autowired
    private WtdkjcxxInfoMapper wtdkjcxxInfoMapper;

    @Override
    public Boolean checkJkrkhh(String jkrkhh) {
        DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(jkrkhh);
        return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
    }

    @Override
    public Boolean checkWtrkhh(String wtkhh) {
        DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(wtkhh);
        return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
    }

    @Override
    public void wtdkjcxxInfoImport(String sjrq,String filePath) {
        List<WtdkjcxxInfo> wtdkjcxxInfoList = null;
        try {
            wtdkjcxxInfoList = this.saxReadWtdkjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkjcxxInfo wtdkjcxxInfo : wtdkjcxxInfoList) {
            if(!checkJkrkhh(wtdkjcxxInfo.getJkrkhh())) {
                log.error("数据出现问题:{}",wtdkjcxxInfo.getJkrkhh());
            }
            if(!checkWtrkhh(wtdkjcxxInfo.getWtrkhh())) {
                log.error("数据出现问题:{}",wtdkjcxxInfo.getWtrkhh());
            }
            wtdkjcxxInfo.setSjrq(sjrq);
            QueryWrapper<WtdkjcxxFullInfo> queryWrapper = new QueryWrapper<WtdkjcxxFullInfo>();
            queryWrapper.eq("dkjjbh", wtdkjcxxInfo.getDkjjbh());
            WtdkjcxxFullInfo selectOne = wtdkjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                wtdkjcxxInfoMapper.insert(wtdkjcxxInfo);
                WtdkjcxxFullInfo wtdkjcxxFullInfo = new WtdkjcxxFullInfo();
                BeanUtil.copyProperties(wtdkjcxxInfo,wtdkjcxxFullInfo,true);
                wtdkjcxxFullInfoMapper.insert(wtdkjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getSjzzrq()) && !selectOne.getSjzzrq().equals(wtdkjcxxInfo.getSjzzrq())) {
                    wtdkjcxxFullInfoMapper.delete(queryWrapper);
                    WtdkjcxxFullInfo wtdkjcxxFullInfo = new WtdkjcxxFullInfo();
                    BeanUtil.copyProperties(wtdkjcxxInfo,wtdkjcxxFullInfo,true);
                    wtdkjcxxFullInfoMapper.insert(wtdkjcxxFullInfo);
                    wtdkjcxxInfoMapper.insert(wtdkjcxxInfo);
                }
            }
        }
    }

    //委托贷款基础
    public static List<WtdkjcxxInfo> saxReadWtdkjcxxInfo(String pathFile) throws IOException {
        WtdkjcxxInfoListener wtdkjcxxInfoListener = new WtdkjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkjcxxInfo.class, wtdkjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkjcxxInfoListener.getWtdkjcxxInfoList();
    }
}
