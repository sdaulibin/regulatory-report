package com.sdjictec.xdfin.regulatory.report;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
import com.sdjictec.xdfin.regulatory.report.service.*;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    private FtydwckfsxxInfoService ftydwckfsxxInfoService;
    @Autowired
    private FtydwckjcxxInfoService ftydwckjcxxInfoService;
    @Autowired
    private FtydwckyexxInfoService ftydwckyexxInfoService;
    @Autowired
    private FtydwdkfkxxInfoService ftydwdkfkxxInfoService;
    @Autowired
    private FtydwdkjcxxInfoService ftydwdkjcxxInfoService;
    @Autowired
    private FtydwdkyexxInfoService ftydwdkyexxInfoService;
    @Autowired
    private JrjgfrxxInfoService jrjgfrxxInfoService;
    @Autowired
    private JrjgfzxxInfoService jrjgfzxxInfoService;
    @Autowired
    private MrfsmchgfsxxInfoService mrfsmchgfsxxInfoService;
    @Autowired
    private MrfsmchgjcxxInfoService mrfsmchgjcxxInfoService;
    @Autowired
    private MrfsmchgyexxInfoService mrfsmchgyexxInfoService;
    @Autowired
    private PjtxztxfsxxInfoService pjtxztxfsxxInfoService;
    @Autowired
    private PjtxztxjcxxInfoService pjtxztxjcxxInfoService;
    @Autowired
    private PjtxztxyexxInfoService pjtxztxyexxInfoService;
    @Autowired
    private TyckfsxxInfoService tyckfsxxInfoService;
    @Autowired
    private TyckjcxxInfoService tyckjcxxInfoService;
    @Autowired
    private TyckyexxInfoService tyckyexxInfoService;
    @Autowired
    private TyjdfsxxInfoService tyjdfsxxInfoService;
    @Autowired
    private TyjdjcxxInfoService tyjdjcxxInfoService;
    @Autowired
    private TyjdyexxInfoService tyjdyexxInfoService;
    @Autowired
    private WtdkfkxxInfoService wtdkfkxxInfoService;
    @Autowired
    private WtdkjcxxInfoService wtdkjcxxInfoService;
    @Autowired
    private WtdkyexxInfoService wtdkyexxInfoService;
    public static final String BASE_PATH= "/Users/binginx/Downloads/西电财务公司/利率报备";
    public static final String[] FILE_NAMES = {};
    @Test
    public void serviceTest() {
        String bwsjrq = "20210628";
        String sjrq = "2021-06-28";
        List<String> listFileNames = FileUtil.listFileNames(BASE_PATH+bwsjrq+"/");
        String filePath = null;
        int index = -1;
        if ((index = listFileNames.indexOf("对公客户信息表-"+bwsjrq+"-企业.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            dgkh(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("对公客户信息表-"+bwsjrq+"-融资.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            dgkh(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("对公客户信息表-"+bwsjrq+"-同业.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            dgkh(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款基础信息表-"+bwsjrq+"-融资.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款基础信息表-"+bwsjrq+"-自营.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款余额信息表-"+bwsjrq+"-融资.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款余额信息表-"+bwsjrq+"-自营.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款放款信息表-"+bwsjrq+"-融资.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkfk(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位贷款放款信息表-"+bwsjrq+"-自营.xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftydkfk(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位存款基础信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftyckjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位存款余额信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftyckye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("非同业单位存款发生额信息表（不含活期存款、协定存款）-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            ftyckfs(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("票据贴现及转贴现基础信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            pjtxjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("票据贴现及转贴现余额信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            pjtxye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("票据贴现及转贴现发生额信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            pjtxfs(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("同业存款基础信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            tyckjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("同业存款余额信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            tyckye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("同业存款发生额信息表（不含活期存款）-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            tyckfs(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("委托贷款基础信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            wtdkjc(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("委托贷款余额信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            wtdkye(sjrq,filePath);
        }
        if ((index = listFileNames.indexOf("委托贷款放款信息表-"+bwsjrq+".xlsx")) >=0) {
            filePath = BASE_PATH+bwsjrq+"/"+listFileNames.get(index);
            wtdkfk(sjrq,filePath);
        }
        for (String fileName:listFileNames) {

        }
    }

    private void dgkh(String sjrq,String filePath) {
        dgkhxxInfoService.dgkhxxImport(sjrq,filePath);
    }
    private void ftydkjc(String sjrq,String filePath) {
        ftydwdkjcxxInfoService.ftydwdkjcxxInfoImport(sjrq,filePath);
    }
    private void ftydkfk(String sjrq,String filePath) {
        ftydwdkfkxxInfoService.ftydwdkfkxxInfoImport(sjrq,filePath);
    }
    private void ftydkye(String sjrq,String filePath) {
        ftydwdkyexxInfoService.ftydwdkjcxxInfoImport(sjrq,filePath);
    }
    private void ftyckjc(String sjrq,String filePath) {
        ftydwckjcxxInfoService.ftydwckjcxxInfoImport(sjrq,filePath);
    }
    private void ftyckfs(String sjrq,String filePath) {
        ftydwckfsxxInfoService.ftydwckfsxxInfoImport(sjrq,filePath);
    }
    private void ftyckye(String sjrq,String filePath){
        ftydwckyexxInfoService.ftydwckyexxInfoImport(sjrq,filePath);
    }
    private void pjtxjc(String sjrq,String filePath) {
        pjtxztxjcxxInfoService.pjtxztxjcxxInfoImport(sjrq,filePath);
    }
    private void pjtxfs(String sjrq,String filePath) {
        pjtxztxfsxxInfoService.pjtxztxfsxxInfoImport(sjrq,filePath);
    }
    private void pjtxye(String sjrq,String filePath){
        pjtxztxyexxInfoService.pjtxztxyexxInfoImport(sjrq,filePath);
    }

    private void wtdkjc(String sjrq,String filePath) {
        wtdkjcxxInfoService.wtdkjcxxInfoImport(sjrq,filePath);
    }
    private void wtdkfk(String sjrq,String filePath) {
        wtdkfkxxInfoService.wtdkfkxxInfoImport(sjrq,filePath);
    }
    private void wtdkye(String sjrq,String filePath){
        wtdkyexxInfoService.wtdkyexxInfoImport(sjrq,filePath);
    }

    private void tyckjc(String sjrq,String filePath) {
        tyckjcxxInfoService.tyckjcxxInfoImport(sjrq,filePath);
    }
    private void tyckfs(String sjrq,String filePath) {
        tyckfsxxInfoService.tyckfsxxInfoImport(sjrq,filePath);
    }
    private void tyckye(String sjrq,String filePath){
        tyckyexxInfoService.tyckyexxInfoImport(sjrq,filePath);
    }
}
