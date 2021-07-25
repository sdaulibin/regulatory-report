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
import com.sdjictec.xdfin.regulatory.report.entity.TyckjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyckyexxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyckyexxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.TyckyexxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckyexxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckyexxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.TyckyexxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 同业存款余额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class TyckyexxInfoServiceImpl extends ServiceImpl<TyckyexxInfoMapper, TyckyexxInfo> implements TyckyexxInfoService {
    @Autowired
    private TyckjcxxFullInfoMapper tyckjcxxFullInfoMapper;
    @Autowired
    private TyckyexxFullInfoMapper tyckyexxFullInfoMapper;
    @Autowired
    private TyckyexxInfoMapper tyckyexxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ckzhbm) {
        if(StrUtil.isEmpty(khh) || StrUtil.isEmpty(ckzhbm)) {
            return false;
        }
        QueryWrapper<TyckjcxxFullInfo> queryWrapper = new QueryWrapper<TyckjcxxFullInfo>();
        queryWrapper.eq("khh", khh);
        queryWrapper.eq("ckzhbm",ckzhbm);
        List<TyckjcxxFullInfo> list = tyckjcxxFullInfoMapper.selectList(queryWrapper);
        return list.isEmpty() ? false : list.size()>0;
    }

    public void tyckyexxInfoImport(String sjrq,String filePath){
        List<TyckyexxInfo> tyckyexxInfoList = null;
        try {
            tyckyexxInfoList = this.saxReadTyckyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckyexxInfo tyckyexxInfo : tyckyexxInfoList) {
            if (!checkKhh(tyckyexxInfo.getKhh(),tyckyexxInfo.getCkzhbm())) {
                log.error("数据出现问题:{},{}",tyckyexxInfo.getKhh(),tyckyexxInfo.getCkzhbm());
                break;
            }
            tyckyexxInfo.setSjrq(sjrq);
            QueryWrapper<TyckyexxFullInfo> queryWrapper = new QueryWrapper<TyckyexxFullInfo>();
            queryWrapper.eq("ckzhbm", tyckyexxInfo.getCkzhbm());
            TyckyexxFullInfo selectOne = tyckyexxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                tyckyexxInfoMapper.insert(tyckyexxInfo);
                TyckyexxFullInfo tyckyexxFullInfo = new TyckyexxFullInfo();
                BeanUtil.copyProperties(tyckyexxInfo,tyckyexxFullInfo,true);
                tyckyexxFullInfoMapper.insert(tyckyexxFullInfo);
            } else {
                if(ObjectUtil.isNull(tyckyexxInfo.getYe()) || (!NumberUtil.toStr(selectOne.getYe()).equals(NumberUtil.toStr(tyckyexxInfo.getYe())))) {
                    tyckyexxFullInfoMapper.delete(queryWrapper);
                    TyckyexxFullInfo tyckyexxFullInfo = new TyckyexxFullInfo();
                    BeanUtil.copyProperties(tyckyexxInfo,tyckyexxFullInfo,true);
                    tyckyexxFullInfoMapper.insert(tyckyexxFullInfo);
                    tyckyexxInfoMapper.insert(tyckyexxInfo);
                }
            }
        }
    }

    //同业存款余额
    public static List<TyckyexxInfo> saxReadTyckyexxInfo(String pathFile) throws IOException {
        TyckyexxInfoListener tyckyexxInfoListener = new TyckyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, TyckyexxInfo.class, tyckyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return tyckyexxInfoListener.getTyckyexxInfoList();
    }
}
