package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.TyckfsxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.listener.TyckjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import com.sdjictec.xdfin.regulatory.report.service.TyckfsxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 同业存款发生额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class TyckfsxxInfoServiceImpl extends ServiceImpl<TyckfsxxInfoMapper, TyckfsxxInfo> implements TyckfsxxInfoService {
    @Autowired
    TyckjcxxFullInfoMapper tyckjcxxFullInfoMapper;
    @Autowired
    TyckyexxFullInfoMapper tyckyexxFullInfoMapper;
    @Autowired
    TyckfsxxInfoMapper tyckfsxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ckzhbm)  {
        if(StrUtil.isEmpty(khh) || StrUtil.isEmpty(ckzhbm)) {
            return false;
        }
        QueryWrapper<TyckjcxxFullInfo> queryWrapper1 = new QueryWrapper<TyckjcxxFullInfo>();
        queryWrapper1.eq("khh", khh);
        queryWrapper1.eq("ckzhbm",ckzhbm);
        List<TyckjcxxFullInfo> list1 = tyckjcxxFullInfoMapper.selectList(queryWrapper1);
        boolean result1 = list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<TyckyexxFullInfo> queryWrapper2 = new QueryWrapper<TyckyexxFullInfo>();
        queryWrapper2.eq("khh", khh);
        queryWrapper2.eq("ckzhbm",ckzhbm);
        List<TyckyexxFullInfo> list2 = tyckyexxFullInfoMapper.selectList(queryWrapper2);
        boolean result2 = list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    @Override
    public void tyckfsxxInfoImport(String sjrq,String filePath) {
        List<TyckfsxxInfo> tyckfsxxInfoList = null;
        try {
            tyckfsxxInfoList = this.saxReadTyckfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckfsxxInfo tyckfsxxInfo : tyckfsxxInfoList) {
            if (!checkKhh(tyckfsxxInfo.getKhh(),tyckfsxxInfo.getCkzhbm())) {
                log.error("数据出现问题:{},{}",tyckfsxxInfo.getKhh(),tyckfsxxInfo.getCkzhbm());
                break;
            }
            tyckfsxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(tyckfsxxInfo.getJylsh())) {
                tyckfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            tyckfsxxInfoMapper.insert(tyckfsxxInfo);
        }
    }

    //同业存款发生
    public static List<TyckfsxxInfo> saxReadTyckfsxxInfo(String pathFile) throws IOException {
        TyckfsxxInfoListener tyckfsxxInfoListener = new TyckfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckfsxxInfo.class, tyckfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckfsxxInfoListener.getTyckfsxxInfoList();
    }
}
