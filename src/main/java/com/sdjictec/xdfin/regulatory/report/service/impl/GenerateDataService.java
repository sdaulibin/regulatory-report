package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateDataService {
    @Autowired
    private DgkhxxInfoMapper dgkhxxInfoMapper;
    @Autowired
    private FtydwckfsxxInfoMapper ftydwckfsxxInfoMapper;
    @Autowired
    private FtydwckjcxxInfoMapper ftydwckjcxxInfoMapper;
    @Autowired
    private FtydwckyexxInfoMapper ftydwckyexxInfoMapper;
    @Autowired
    private FtydwdkfkxxInfoMapper ftydwdkfkxxInfoMapper;
    @Autowired
    private FtydwdkjcxxInfoMapper ftydwdkjcxxInfoMapper;
    @Autowired
    private FtydwdkyexxInfoMapper ftydwdkyexxInfoMapper;
    @Autowired
    private JrjgfrxxInfoMapper jrjgfrxxInfoMapper;
    @Autowired
    private JrjgfzxxInfoMapper jrjgfzxxInfoMapper;
    @Autowired
    private MrfsmchgfsxxInfoMapper mrfsmchgfsxxInfoMapper;
    @Autowired
    private MrfsmchgjcxxInfoMapper mrfsmchgjcxxInfoMapper;
    @Autowired
    private MrfsmchgyexxInfoMapper mrfsmchgyexxInfoMapper;
    @Autowired
    private PjtxztxfsxxInfoMapper pjtxztxfsxxInfoMapper;
    @Autowired
    private PjtxztxjcxxInfoMapper pjtxztxjcxxInfoMapper;
    @Autowired
    private PjtxztxyexxInfoMapper pjtxztxyexxInfoMapper;
    @Autowired
    private TyckfsxxInfoMapper tyckfsxxInfoMapper;
    @Autowired
    private TyckjcxxInfoMapper tyckjcxxInfoMapper;
    @Autowired
    private TyckyexxInfoMapper tyckyexxInfoMapper;
    @Autowired
    private TyjdfsxxInfoMapper tyjdfsxxInfoMapper;
    @Autowired
    private TyjdjcxxInfoMapper tyjdjcxxInfoMapper;
    @Autowired
    private TyjdyexxInfoMapper tyjdyexxInfoMapper;
    @Autowired
    private WtdkfkxxInfoMapper wtdkfkxxInfoMapper;
    @Autowired
    private WtdkjcxxInfoMapper wtdkjcxxInfoMapper;
    @Autowired
    private WtdkyexxInfoMapper wtdkyexxInfoMapper;

//    public static final String BASE_PATH= "/Users/binginx/Downloads/西电财务公司/人行报文20210627/C5007761000013_";

    public void generateData(String bwsjrq,String sjrq) {
        String typeStr = "DGKHXX,JGFRXX,JGFZXX,DWDKJC,DWDKYE,DWDKFK,WTDKJC,WTDKYE,WTDKFK,DWCKJC,DWCKYE,DWCKFS,TYCKJC,TYCKYE,TYCKFS,TYJDJC,TYJDYE,TYJDFS,MRFSJC,MRFSYE,MRFSFS,PJTXJC,PJTXYE,PJTXFS,GRKHXX,GRDKJC,GRDKYE,GRDKFK,TZYWYE,TZYWJY,TZYWZD,TZYWFQ,GRCKJC,GRCKYE,GRCKFS,FTPDJB";
        String[] split = typeStr.split(",");
//        String bwsjrq = "20210628";
//        String sjrq = "2021-06-28";
        for (int i = 0; i < split.length; i++) {
            File txt = null;
            getFile(sjrq,bwsjrq,split[i],txt);
        }
    }

    public void getFile(String sjrq,String bwsjrq,String type,File txt) {
        String BASE_PATH= "/Users/binginx/Downloads/西电财务公司/人行报文"+bwsjrq+"/C5007761000013_";
        List<String> list = null;
        if("DGKHXX".equals(type)) {
            list = dgkhxxInfoMapper.getContactStr(sjrq);
        } else if("JGFRXX".equals(type)) {
            list = jrjgfrxxInfoMapper.getContactStr(sjrq);
        } else if("JGFZXX".equals(type)) {
            list = jrjgfzxxInfoMapper.getContactStr(sjrq);
        } else if("DWDKJC".equals(type)) {
            list = ftydwdkjcxxInfoMapper.getContactStr(sjrq);
        } else if("DWDKYE".equals(type)) {
            list = ftydwdkyexxInfoMapper.getContactStr(sjrq);
        } else if("DWDKFK".equals(type)) {
            list = ftydwdkfkxxInfoMapper.getContactStr(sjrq);
        } else if("WTDKJC".equals(type)) {
            list = wtdkjcxxInfoMapper.getContactStr(sjrq);
        } else if("WTDKYE".equals(type)) {
            list = wtdkyexxInfoMapper.getContactStr(sjrq);
        } else if("WTDKFK".equals(type)) {
            list = wtdkfkxxInfoMapper.getContactStr(sjrq);
        } else if("DWCKJC".equals(type)) {
            list = ftydwckjcxxInfoMapper.getContactStr(sjrq);
        } else if("DWCKYE".equals(type)) {
            list = ftydwckyexxInfoMapper.getContactStr(sjrq);
        } else if("DWCKFS".equals(type)) {
            list = ftydwckfsxxInfoMapper.getContactStr(sjrq);
        } else if("TYCKJC".equals(type)) {
            list = tyckjcxxInfoMapper.getContactStr(sjrq);
        } else if("TYCKYE".equals(type)) {
            list = tyckyexxInfoMapper.getContactStr(sjrq);
        } else if("TYCKFS".equals(type)) {
            list = tyckfsxxInfoMapper.getContactStr(sjrq);
        } else if("TYJDJC".equals(type)) {
            list = tyjdjcxxInfoMapper.getContactStr(sjrq);
        } else if("TYJDYE".equals(type)) {
            list = tyjdyexxInfoMapper.getContactStr(sjrq);
        } else if("TYJDFS".equals(type)) {
            list = tyjdfsxxInfoMapper.getContactStr(sjrq);
        } else if("MRFSJC".equals(type)) {
            list = mrfsmchgjcxxInfoMapper.getContactStr(sjrq);
        } else if("MRFSYE".equals(type)) {
            list = mrfsmchgyexxInfoMapper.getContactStr(sjrq);
        } else if("MRFSFS".equals(type)) {
            list = mrfsmchgfsxxInfoMapper.getContactStr(sjrq);
        } else if("PJTXJC".equals(type)) {
            list = pjtxztxjcxxInfoMapper.getContactStr(sjrq);
        } else if("PJTXYE".equals(type)) {
            list = pjtxztxyexxInfoMapper.getContactStr(sjrq);
        } else if("PJTXFS".equals(type)) {
            list = pjtxztxfsxxInfoMapper.getContactStr(sjrq);
        } else if("GRKHXX".equals(type)) {
            list = new ArrayList<>();
        } else if("GRDKJC".equals(type)) {
            list = new ArrayList<>();
        } else if("GRDKYE".equals(type)) {
            list = new ArrayList<>();
        } else if("GRDKFK".equals(type)) {
            list = new ArrayList<>();
        } else if("TZYWYE".equals(type)) {
            list = new ArrayList<>();
        } else if("TZYWJY".equals(type)) {
            list = new ArrayList<>();
        } else if("TZYWZD".equals(type)) {
            list = new ArrayList<>();
        } else if("TZYWFQ".equals(type)) {
            list = new ArrayList<>();
        } else if("GRCKJC".equals(type)) {
            list = new ArrayList<>();
        } else if("GRCKYE".equals(type)) {
            list = new ArrayList<>();
        } else if("GRCKFS".equals(type)) {
            list = new ArrayList<>();
        } else if("FTPDJB".equals(type)) {
            list = new ArrayList<>();
        }
        if (!list.isEmpty()) {
            txt = FileUtil.newFile(BASE_PATH + type + "_" + bwsjrq + "_1_1.txt");
            for (String string:list) {
                if(list.lastIndexOf(string) == list.size()-1) {
                    FileUtil.appendString(string, txt, "UTF-8");
                } else {
                    FileUtil.appendString(string+"\n", txt, "UTF-8");
                }
            }
        } else {
            txt = FileUtil.touch(BASE_PATH + type + "_" + bwsjrq + "_1_1.txt");
        }
        //File txt = FileUtil.writeLines(list, FileUtil.newFile(BASE_PATH+type+"_"+bwsjrq+"_1_1.txt"), "UTF-8");
        String encode = Base64.encode(ZipUtil.zip(txt));
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<Package>\n" +
                "  <bankcode>C5007761000013</bankcode>\n" +
                "  <reporttaskdate>"+bwsjrq+"</reporttaskdate>\n" +
                "  <reporttypecode>"+type+"</reporttypecode>\n" +
                "  <totalseparate>1</totalseparate>\n" +
                "  <separateseq>1</separateseq>\n" +
                "  <reportflag>FTRT</reportflag>\n" +
                "  <rownum>"+list.size()+"</rownum>\n" +
                "  <totalrownum>"+list.size()+"</totalrownum>\n" +
                "  <filecontent>"+encode+"</filecontent>\n" +
                "</Package>" ;
        File xmlFile = FileUtil.appendString(xmlStr,FileUtil.newFile(BASE_PATH+type+"_"+bwsjrq+"_1_1.xml"),"UTF-8");
        ZipUtil.zip(xmlFile);
    }
}
