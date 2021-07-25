package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.listener.FtydwdkfkxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkfkxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.mapper.FtydwdkyexxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.FtydwdkfkxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 非同业单位贷款放款信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class FtydwdkfkxxInfoServiceImpl extends ServiceImpl<FtydwdkfkxxInfoMapper, FtydwdkfkxxInfo> implements FtydwdkfkxxInfoService {

    @Autowired
    FtydwdkjcxxFullInfoMapper ftydwdkjcxxFullInfoMapper;
    @Autowired
    FtydwdkyexxFullInfoMapper ftydwdkyexxFullInfoMapper;
    @Autowired
    FtydwdkfkxxInfoMapper ftydwdkfkxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String dkjjbh)  {
        if(StrUtil.isEmpty(khh) || StrUtil.isEmpty(dkjjbh)) {
            return false;
        }
        QueryWrapper<FtydwdkjcxxFullInfo> queryWrapper1 = new QueryWrapper<FtydwdkjcxxFullInfo>();
        queryWrapper1.eq("khh", khh);
        queryWrapper1.eq("dkjjbh",dkjjbh);
        List<FtydwdkjcxxFullInfo> list1 = ftydwdkjcxxFullInfoMapper.selectList(queryWrapper1);
        boolean result1 = list1.isEmpty() ? false : list1.size()>0;

        QueryWrapper<FtydwdkyexxFullInfo> queryWrapper2 = new QueryWrapper<FtydwdkyexxFullInfo>();
        queryWrapper2.eq("khh", khh);
        queryWrapper2.eq("dkjjbh",dkjjbh);
        List<FtydwdkyexxFullInfo> list2 = ftydwdkyexxFullInfoMapper.selectList(queryWrapper2);
        boolean result2 = list2.isEmpty() ? false : list2.size()>0;
        return result1 && result2;
    }

    public void ftydwdkfkxxInfoImport(String sjrq,String filePath) {
        List<FtydwdkfkxxInfo> ftydwdkfkxxInfoList = null;
        try {
            ftydwdkfkxxInfoList = this.saxReadFtydwdkfkxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkfkxxInfo ftydwdkfkxxInfo : ftydwdkfkxxInfoList) {
            if(!this.checkKhh(ftydwdkfkxxInfo.getKhh(),ftydwdkfkxxInfo.getDkjjbh())) {
                log.error("数据出现问题:{},{}",ftydwdkfkxxInfo.getKhh(),ftydwdkfkxxInfo.getDkjjbh());
            }
            if(StrUtil.isEmpty(ftydwdkfkxxInfo.getJylsh())) {
                ftydwdkfkxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            ftydwdkfkxxInfo.setSjrq(sjrq);
            ftydwdkfkxxInfoMapper.insert(ftydwdkfkxxInfo);
        }
    }

    public static List<FtydwdkfkxxInfo> saxReadFtydwdkfkxxInfo(String pathFile) throws IOException {
        FtydwdkfkxxInfoListener ftydwdkfkxxInfoListener = new FtydwdkfkxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, FtydwdkfkxxInfo.class, ftydwdkfkxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return ftydwdkfkxxInfoListener.getFtydwdkfkxxInfoList();
    }
}
