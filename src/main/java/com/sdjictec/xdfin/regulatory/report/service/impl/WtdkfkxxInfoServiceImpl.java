package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkfkxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkyexxFullInfo;
import com.sdjictec.xdfin.regulatory.report.listener.WtdkfkxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkfkxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkyexxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.WtdkfkxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 委托贷款放款信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class WtdkfkxxInfoServiceImpl extends ServiceImpl<WtdkfkxxInfoMapper, WtdkfkxxInfo> implements WtdkfkxxInfoService {

    @Autowired
    private WtdkjcxxFullInfoMapper wtdkjcxxFullInfoMapper;
    @Autowired
    private WtdkyexxFullInfoMapper wtdkyexxFullInfoMapper;
    @Autowired
    private WtdkfkxxInfoMapper wtdkfkxxInfoMapper;

    @Override
    public Boolean checkJkrkhh(String jkrkhh, String dkjjbh) {
        QueryWrapper<WtdkjcxxFullInfo> queryWrapper1 = new QueryWrapper<WtdkjcxxFullInfo>();
        queryWrapper1.eq("jkrkhh", jkrkhh);
        queryWrapper1.eq("dkjjbh",dkjjbh);
        List<WtdkjcxxFullInfo> list1 = wtdkjcxxFullInfoMapper.selectList(queryWrapper1);
        boolean result1 =  list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<WtdkyexxFullInfo> queryWrapper2 = new QueryWrapper<WtdkyexxFullInfo>();
        queryWrapper2.eq("jkrkhh", jkrkhh);
        queryWrapper2.eq("dkjjbh",dkjjbh);
        List<WtdkyexxFullInfo> list2 = wtdkyexxFullInfoMapper.selectList(queryWrapper2);
        boolean result2 =  list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    @Override
    public Boolean checkWtrkhh(String wtrkhh, String dkjjbh) {
        QueryWrapper<WtdkjcxxFullInfo> queryWrapper1 = new QueryWrapper<WtdkjcxxFullInfo>();
        queryWrapper1.eq("jkrkhh", wtrkhh);
        queryWrapper1.eq("dkjjbh",dkjjbh);
        List<WtdkjcxxFullInfo> list1 = wtdkjcxxFullInfoMapper.selectList(queryWrapper1);
        boolean result1 =  list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<WtdkyexxFullInfo> queryWrapper2 = new QueryWrapper<WtdkyexxFullInfo>();
        queryWrapper2.eq("jkrkhh", wtrkhh);
        queryWrapper2.eq("dkjjbh",dkjjbh);
        List<WtdkyexxFullInfo> list2 = wtdkyexxFullInfoMapper.selectList(queryWrapper2);
        boolean result2 =  list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    @Override
    public void wtdkfkxxInfoImport(String sjrq,String filePath) {
        List<WtdkfkxxInfo> wtdkfkxxInfoList = null;
        try {
            wtdkfkxxInfoList = this.saxReadWtdkfkxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkfkxxInfo wtdkfkxxInfo : wtdkfkxxInfoList) {
            if(!checkJkrkhh(wtdkfkxxInfo.getJkrkhh(),wtdkfkxxInfo.getDkjjbh())) {
                log.error("数据出现问题:{},{}",wtdkfkxxInfo.getJkrkhh(),wtdkfkxxInfo.getDkjjbh());
            }
            if(!checkWtrkhh(wtdkfkxxInfo.getWtrkhh(),wtdkfkxxInfo.getDkjjbh())) {
                log.error("数据出现问题:{}",wtdkfkxxInfo.getWtrkhh(),wtdkfkxxInfo.getDkjjbh());
            }
            wtdkfkxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(wtdkfkxxInfo.getJylsh())) {
                wtdkfkxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            wtdkfkxxInfoMapper.insert(wtdkfkxxInfo);
        }
    }

    //委托贷款放款
    public static List<WtdkfkxxInfo> saxReadWtdkfkxxInfo(String pathFile) throws IOException {
        WtdkfkxxInfoListener wtdkfkxxInfoListener = new WtdkfkxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, WtdkfkxxInfo.class, wtdkfkxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return wtdkfkxxInfoListener.getWtdkfkxxInfoList();
    }
}
