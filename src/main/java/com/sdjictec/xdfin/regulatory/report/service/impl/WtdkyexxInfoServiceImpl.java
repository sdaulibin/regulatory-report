package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.WtdkyexxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import com.sdjictec.xdfin.regulatory.report.service.WtdkyexxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 委托贷款余额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class WtdkyexxInfoServiceImpl extends ServiceImpl<WtdkyexxInfoMapper, WtdkyexxInfo> implements WtdkyexxInfoService {
    @Autowired
    private WtdkjcxxFullInfoMapper wtdkjcxxFullInfoMapper;
    @Autowired
    private WtdkyexxFullInfoMapper wtdkyexxFullInfoMapper;
    @Autowired
    private WtdkyexxInfoMapper wtdkyexxInfoMapper;

    @Override
    public Boolean checkJkrkhh(String jkrkhh, String dkjjbh) {
        QueryWrapper<WtdkjcxxFullInfo> queryWrapper = new QueryWrapper<WtdkjcxxFullInfo>();
        queryWrapper.eq("jkrkhh", jkrkhh);
        queryWrapper.eq("dkjjbh",dkjjbh);
        List<WtdkjcxxFullInfo> list = wtdkjcxxFullInfoMapper.selectList(queryWrapper);
        return list.isEmpty() ? false : list.size()>0;
    }

    @Override
    public Boolean checkWtrkhh(String wtrkhh, String dkjjbh) {
        QueryWrapper<WtdkjcxxFullInfo> queryWrapper = new QueryWrapper<WtdkjcxxFullInfo>();
        queryWrapper.eq("wtrkhh", wtrkhh);
        queryWrapper.eq("dkjjbh",dkjjbh);
        List<WtdkjcxxFullInfo> list = wtdkjcxxFullInfoMapper.selectList(queryWrapper);
        return list.isEmpty() ? false : list.size()>0;
    }

    @Override
    public void wtdkyexxInfoImport(String sjrq,String filePath){
        List<WtdkyexxInfo> wtdkyexxInfoList = null;
        try {
            wtdkyexxInfoList = this.saxReadWtdkyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkyexxInfo wtdkyexxInfo : wtdkyexxInfoList) {
            if(!checkJkrkhh(wtdkyexxInfo.getJkrkhh(),wtdkyexxInfo.getDkjjbh())) {
                log.error("数据出现问题:{},{}",wtdkyexxInfo.getJkrkhh(),wtdkyexxInfo.getDkjjbh());
            }
            if(!checkWtrkhh(wtdkyexxInfo.getWtrkhh(),wtdkyexxInfo.getDkjjbh())) {
                log.error("数据出现问题:{},{}",wtdkyexxInfo.getJkrkhh(),wtdkyexxInfo.getDkjjbh());
            }
            wtdkyexxInfo.setSjrq(sjrq);
            QueryWrapper<WtdkyexxFullInfo> queryWrapper = new QueryWrapper<WtdkyexxFullInfo>();
            queryWrapper.eq("dkjjbh", wtdkyexxInfo.getDkjjbh());
            WtdkyexxFullInfo selectOne = wtdkyexxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                wtdkyexxInfoMapper.insert(wtdkyexxInfo);
                WtdkyexxFullInfo wtdkyexxFullInfo = new WtdkyexxFullInfo();
                BeanUtil.copyProperties(wtdkyexxInfo,wtdkyexxFullInfo,true);
                wtdkyexxFullInfoMapper.insert(wtdkyexxFullInfo);
            } else {
                if(!NumberUtil.toStr(selectOne.getDkye()).equals(NumberUtil.toStr(wtdkyexxInfo.getDkye()))) {
                    wtdkyexxFullInfoMapper.delete(queryWrapper);
                    WtdkyexxFullInfo wtdkyexxFullInfo = new WtdkyexxFullInfo();
                    BeanUtil.copyProperties(wtdkyexxInfo,wtdkyexxFullInfo,true);
                    wtdkyexxFullInfoMapper.insert(wtdkyexxFullInfo);
                    wtdkyexxInfoMapper.insert(wtdkyexxInfo);
                }
            }
        }
    }

    //委托贷款余额
    public static List<WtdkyexxInfo> saxReadWtdkyexxInfo(String pathFile) throws IOException {
        WtdkyexxInfoListener wtdkyexxInfoListener = new WtdkyexxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkyexxInfo.class, wtdkyexxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkyexxInfoListener.getWtdkyexxInfoList();
    }
}
