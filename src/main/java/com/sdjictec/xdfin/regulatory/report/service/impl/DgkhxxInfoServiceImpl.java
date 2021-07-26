package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.DgkhxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import com.sdjictec.xdfin.regulatory.report.util.ExcelCheckResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 对公客户信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class DgkhxxInfoServiceImpl implements DgkhxxInfoService {
    @Autowired
    private DgkhxxInfoMapper dgkhxxInfoMapper;

    @Autowired
    private DgkhxxFullInfoMapper dgkhxxFullInfoMapper;

    @Override
    public ExcelCheckResult checkImportExcel(List<DgkhxxInfo> dgkhxxInfoList) {
        for (DgkhxxInfo dgkhxxInfo:dgkhxxInfoList) {
            QueryWrapper<DgkhxxInfo> queryWrapper = new QueryWrapper<DgkhxxInfo>();
            queryWrapper.eq("khh", dgkhxxInfo.getKhh());
            DgkhxxInfo selectOne = dgkhxxInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                dgkhxxInfo.setSjrq(DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
                dgkhxxInfoMapper.insert(dgkhxxInfo);
            } else {
                if(!NumberUtil.toStr(selectOne.getYyed()).equals(NumberUtil.toStr(dgkhxxInfo.getYyed()))) {
                    dgkhxxInfoMapper.delete(queryWrapper);
                    dgkhxxInfoMapper.insert(dgkhxxInfo);
                }
            }
        }
        return null;
    }

    @Override
    public DgkhxxFullInfo getByHhh(String khh) {
        QueryWrapper<DgkhxxFullInfo> queryWrapper = new QueryWrapper<DgkhxxFullInfo>();
        queryWrapper.eq("khh", khh);
        DgkhxxFullInfo selectOne = dgkhxxFullInfoMapper.selectOne(queryWrapper);
        return selectOne;
    }

    @Override
    public void dgkhxxImport(String sjrq, String filePath) {
        //对公客户-企业
        List<DgkhxxInfo> dgkhxxInfoList = null;
        try {
            dgkhxxInfoList = this.saxReadDgkhxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (DgkhxxInfo dgkhxxInfo : dgkhxxInfoList) {
            dgkhxxInfo.setSjrq(sjrq);
//            log.info(dgkhxxInfo.toString());
            QueryWrapper<DgkhxxFullInfo> queryWrapper = new QueryWrapper<DgkhxxFullInfo>();
            queryWrapper.eq("khh", dgkhxxInfo.getKhh());
            DgkhxxFullInfo selectOne = dgkhxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                dgkhxxInfoMapper.insert(dgkhxxInfo);
                DgkhxxFullInfo dgkhxxFullInfo = new DgkhxxFullInfo();
                BeanUtil.copyProperties(dgkhxxInfo,dgkhxxFullInfo,true);
                dgkhxxFullInfoMapper.insert(dgkhxxFullInfo);
            } else {
                if(ObjectUtil.isNull(dgkhxxInfo.getYyed()) || (ObjectUtil.isNotNull(selectOne.getYyed()) && !NumberUtil.toStr(selectOne.getYyed()).equals(NumberUtil.toStr(dgkhxxInfo.getYyed())))) {
                    dgkhxxFullInfoMapper.delete(queryWrapper);
                    DgkhxxFullInfo dgkhxxFullInfo = new DgkhxxFullInfo();
                    BeanUtil.copyProperties(dgkhxxInfo,dgkhxxFullInfo,true);
                    dgkhxxFullInfoMapper.insert(dgkhxxFullInfo);
                    dgkhxxInfoMapper.insert(dgkhxxInfo);
                }
            }
        }
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<DgkhxxInfo> queryWrapper = new QueryWrapper<DgkhxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return dgkhxxInfoMapper.delete(queryWrapper);
    }

    //对公客户
    public static List<DgkhxxInfo> saxReadDgkhxxInfo(String pathFile) throws IOException {
        DgkhxxInfoListener dgkhxxListener = new DgkhxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, DgkhxxInfo.class, dgkhxxListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return dgkhxxListener.getDgkhxxList();
    }
}
