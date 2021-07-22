package com.sdjictec.xdfin.regulatory.report.service;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DgkhxxServiceTest {
    @Autowired
    private DgkhxxInfoMapper dgkhxxInfoMapper;

    @Test
    public void testDgkhxx() {
        List<DgkhxxInfo> dgkhxxInfoList = null;
        try {
            dgkhxxInfoList = EasyXlsUtil.saxReadDgkhxxInfo("/Users/binginx/Downloads/西电财务公司/西电财司利率报备2021.6.27/对公客户信息表-20210627-企业.xlsx");
        } catch (IOException e) {
            log.error("对公客户信息表读取失败:{}", e.getMessage());
        }
        for (DgkhxxInfo dgkhxxInfo : dgkhxxInfoList) {
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
    }
    @Test
    public void testDgkhxxList() {
        List<DgkhxxInfo> dgkhxxInfoList = dgkhxxInfoMapper.getDgkhxxInfoList("2021-07-22");
        StringBuffer stringBuffer = new StringBuffer();
        for (DgkhxxInfo dgkhxxInfo:dgkhxxInfoList) {
            log.info(dgkhxxInfo.toString());
            stringBuffer.append("2021-6-27").append(dgkhxxInfo.getKhh()).append(dgkhxxInfo.getNbjgh()).append(dgkhxxInfo.getGmjjbmfl());
        }
    }

    @Test
    public void testDgkhxxStr() {
        List<String> dgkhxxInfoStrList = dgkhxxInfoMapper.getContactStr("2021-07-22");
        for (String string:dgkhxxInfoStrList) {
            log.info(string);
        }
        File txt = FileUtil.appendLines(dgkhxxInfoStrList, FileUtil.newFile("/Users/binginx/Downloads/西电财务公司/西电财司利率报备2021.6.27/对公客户信息表.txt"), "UTF-8");
        File txtZip = ZipUtil.zip(txt);
        String encode = Base64.encode(txtZip);
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<Package>\n" +
                "  <bankcode>C1088237000013</bankcode>\n" +
                "  <reporttaskdate>20210630</reporttaskdate>\n" +
                "  <reporttypecode>DGKHXX</reporttypecode>\n" +
                "  <totalseparate>1</totalseparate>\n" +
                "  <separateseq>1</separateseq>\n" +
                "  <reportflag>FTRT</reportflag>\n" +
                "  <rownum>1</rownum>\n" +
                "  <totalrownum>1</totalrownum>\n" +
                "  <filecontent>"+encode+"</filecontent>\n" +
                "</Package>" ;
        File xmlFile = FileUtil.appendString(xmlStr,FileUtil.newFile("/Users/binginx/Downloads/西电财务公司/西电财司利率报备2021.6.27/对公客户信息表xml.xml"),"UTF-8");
        File xmlZip = ZipUtil.zip(xmlFile);
    }
}
