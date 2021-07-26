package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxyexxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.PjtxztxyexxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.PjtxztxjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.PjtxztxyexxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.PjtxztxyexxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 票据贴现及转贴现余额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class PjtxztxyexxInfoServiceImpl extends ServiceImpl<PjtxztxyexxInfoMapper, PjtxztxyexxInfo> implements PjtxztxyexxInfoService {
    @Autowired
    PjtxztxjcxxInfoMapper pjtxztxjcxxInfoMapper;
    @Autowired
    PjtxztxyexxInfoMapper pjtxztxyexxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String ywbm,String sjrq)  {
        if(StrUtil.isEmpty(ywbm)) {
            return false;
        }
        List<PjtxztxjcxxInfo> list1 = new ArrayList<PjtxztxjcxxInfo>();
        if(StrUtil.isEmpty(khh)) {
            QueryWrapper<PjtxztxjcxxInfo> queryWrapper1 = new QueryWrapper<PjtxztxjcxxInfo>();
            queryWrapper1.eq("ywbm",ywbm);
            queryWrapper1.eq("sjrq",sjrq);
            list1 = pjtxztxjcxxInfoMapper.selectList(queryWrapper1);
        } else {
            QueryWrapper<PjtxztxjcxxInfo> queryWrapper1 = new QueryWrapper<PjtxztxjcxxInfo>();
            queryWrapper1.eq("khh", khh);
            queryWrapper1.eq("ywbm",ywbm);
            queryWrapper1.eq("sjrq",sjrq);
            list1 = pjtxztxjcxxInfoMapper.selectList(queryWrapper1);
        }

        boolean result1 = list1.isEmpty() ? false : list1.size()>0;
        return result1;
    }
    @Override
    public void pjtxztxyexxInfoImport(String sjrq,String filePath){
        List<PjtxztxyexxInfo> pjtxztxyexxInfoList = null;
        try {
            pjtxztxyexxInfoList = this.saxReadPjtxztxyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxyexxInfo pjtxztxyexxInfo : pjtxztxyexxInfoList) {
            if(!this.checkKhh(pjtxztxyexxInfo.getKhh(),pjtxztxyexxInfo.getYwbm(),sjrq)) {
                log.error("数据出现问题:{},{},{}",pjtxztxyexxInfo.getKhh(),pjtxztxyexxInfo.getYwbm(),sjrq);
            }
            pjtxztxyexxInfo.setSjrq(sjrq);
            pjtxztxyexxInfoMapper.insert(pjtxztxyexxInfo);
        }
    }
    //票据贴现余额
    public static List<PjtxztxyexxInfo> saxReadPjtxztxyexxInfo(String pathFile) throws IOException {
        PjtxztxyexxInfoListener pjtxztxyexxInfoListener = new PjtxztxyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxyexxInfo.class, pjtxztxyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxyexxInfoListener.getPjtxztxyexxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<PjtxztxyexxInfo> queryWrapper = new QueryWrapper<PjtxztxyexxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return pjtxztxyexxInfoMapper.delete(queryWrapper);
    }
}
