package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.PjtxztxfsxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import com.sdjictec.xdfin.regulatory.report.service.PjtxztxfsxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 票据贴现及转贴现发生额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class PjtxztxfsxxInfoServiceImpl extends ServiceImpl<PjtxztxfsxxInfoMapper, PjtxztxfsxxInfo> implements PjtxztxfsxxInfoService {
    @Autowired
    PjtxztxjcxxInfoMapper pjtxztxjcxxInfoMapper;
    @Autowired
    PjtxztxyexxInfoMapper pjtxztxyexxInfoMapper;
    @Autowired
    PjtxztxfsxxInfoMapper pjtxztxfsxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ywbm,String sjrq)  {
        if(StrUtil.isEmpty(khh) || StrUtil.isEmpty(ywbm)) {
            return false;
        }
        QueryWrapper<PjtxztxjcxxInfo> queryWrapper1 = new QueryWrapper<PjtxztxjcxxInfo>();
        queryWrapper1.eq("khh", khh);
        queryWrapper1.eq("ywbm",ywbm);
        queryWrapper1.eq("sjrq",sjrq);
        List<PjtxztxjcxxInfo> list1 = pjtxztxjcxxInfoMapper.selectList(queryWrapper1);
        boolean result1 = list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<PjtxztxyexxInfo> queryWrapper2 = new QueryWrapper<PjtxztxyexxInfo>();
        queryWrapper2.eq("khh", khh);
        queryWrapper2.eq("ywbm",ywbm);
        queryWrapper1.eq("sjrq",sjrq);
        List<PjtxztxyexxInfo> list2 = pjtxztxyexxInfoMapper.selectList(queryWrapper2);
        boolean result2 = list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    @Override
    public void pjtxztxfsxxInfoImport(String sjrq,String filePath) {
        List<PjtxztxfsxxInfo> pjtxztxfsxxInfoList = null;
        try {
            pjtxztxfsxxInfoList = this.saxReadPjtxztxfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxfsxxInfo pjtxztxfsxxInfo : pjtxztxfsxxInfoList) {
            if(!this.checkKhh(pjtxztxfsxxInfo.getKhh(),pjtxztxfsxxInfo.getYwbm(),sjrq)) {
                log.error("数据出现问题:{},{},{}",pjtxztxfsxxInfo.getKhh(),pjtxztxfsxxInfo.getYwbm(),sjrq);
            }
            if(StrUtil.isEmpty(pjtxztxfsxxInfo.getJylsh())) {
                pjtxztxfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            pjtxztxfsxxInfo.setSjrq(sjrq);
            pjtxztxfsxxInfoMapper.insert(pjtxztxfsxxInfo);
        }
    }

    //票据贴现发生
    public static List<PjtxztxfsxxInfo> saxReadPjtxztxfsxxInfo(String pathFile) throws IOException {
        PjtxztxfsxxInfoListener pjtxztxfsxxInfoListener = new PjtxztxfsxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxfsxxInfo.class, pjtxztxfsxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxfsxxInfoListener.getPjtxztxfsxxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<PjtxztxfsxxInfo> queryWrapper = new QueryWrapper<PjtxztxfsxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return pjtxztxfsxxInfoMapper.delete(queryWrapper);
    }
}
