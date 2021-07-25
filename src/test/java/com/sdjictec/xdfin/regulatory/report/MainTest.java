package com.sdjictec.xdfin.regulatory.report;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjictec.xdfin.regulatory.report.entity.*;
import com.sdjictec.xdfin.regulatory.report.mapper.*;
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
public class MainTest {
    @Autowired
    private DgkhxxInfoMapper dgkhxxInfoMapper;
    @Autowired
    private DgkhxxFullInfoMapper dgkhxxFullInfoMapper;
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
    private FtydwdkjcxxFullInfoMapper ftydwdkjcxxFullInfoMapper;
    @Autowired
    private FtydwdkyexxInfoMapper ftydwdkyexxInfoMapper;
    @Autowired
    private FtydwdkyexxFullInfoMapper ftydwdkyexxFullInfoMapper;
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
    private TyckjcxxFullInfoMapper tyckjcxxFullInfoMapper;
    @Autowired
    private TyckyexxInfoMapper tyckyexxInfoMapper;
    @Autowired
    private TyckyexxFullInfoMapper tyckyexxFullInfoMapper;
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
    private WtdkjcxxFullInfoMapper wtdkjcxxFullInfoMapper;
    @Autowired
    private WtdkyexxInfoMapper wtdkyexxInfoMapper;
    @Autowired
    private WtdkyexxFullInfoMapper wtdkyexxFullInfoMapper;
    public static final String BASE_PATH= "/Users/binginx/Downloads/西电财务公司/利率报备";
    @Test
    public void mainTest() {
        //dgkh("2021-06-27");
//        ftydk("2021-06-27");
//        ftyck("2021-06-27");
//        pjtx("2021-06-27");
//        wtdk("2021-06-27");
//        tyck("2021-06-27");
        String bwsjrq = "20210628";
        String sjrq = "2021-06-28";
        List<String> listFileNames = FileUtil.listFileNames(BASE_PATH+bwsjrq+"/");
        for (String fileName:listFileNames) {
            String filePath = BASE_PATH+bwsjrq+"/"+fileName;
            if (fileName.contains("对公客户信息表")) {
                dgkh(sjrq,filePath);
            }
            if (fileName.contains("非同业单位贷款基础信息表-"+bwsjrq)) {
                ftydkjc(sjrq,filePath);
            }
            if (fileName.contains("非同业单位贷款放款信息表-"+bwsjrq)) {
                ftydkfk(sjrq,filePath);
            }
            if (fileName.contains("非同业单位贷款余额信息表-"+bwsjrq)) {
                ftydkye(sjrq,filePath);
            }
            if (fileName.contains("非同业单位存款基础信息表-"+bwsjrq)) {
                ftyckjc(sjrq,filePath);
            }
            if (fileName.contains("非同业单位存款发生额信息表（不含活期存款、协定存款）-"+bwsjrq)) {
                ftyckfs(sjrq,filePath);
            }
            if (fileName.contains("非同业单位存款余额信息表-"+bwsjrq)) {
                ftyckye(sjrq,filePath);
            }
            if (fileName.contains("票据贴现及转贴现发生额信息表-"+bwsjrq)) {
                pjtxfs(sjrq,filePath);
            }
            if (fileName.contains("票据贴现及转贴现基础信息表-"+bwsjrq)) {
                pjtxjc(sjrq,filePath);
            }
            if (fileName.contains("票据贴现及转贴现余额信息表-"+bwsjrq)) {
                pjtxye(sjrq,filePath);
            }
            if (fileName.contains("同业存款发生额信息表（不含活期存款）-"+bwsjrq)) {
                tyckfs(sjrq,filePath);
            }
            if (fileName.contains("同业存款基础信息表-"+bwsjrq)) {
                tyckjc(sjrq,filePath);
            }
            if (fileName.contains("同业存款余额信息表-"+bwsjrq)) {
                tyckye(sjrq,filePath);
            }
            if (fileName.contains("委托贷款放款信息表-"+bwsjrq)) {
                wtdkfk(sjrq,filePath);
            }
            if (fileName.contains("委托贷款基础信息表-"+bwsjrq)) {
                wtdkjc(sjrq,filePath);
            }
            if (fileName.contains("委托贷款余额信息表-"+bwsjrq)) {
                wtdkye(sjrq,filePath);
            }
        }
    }

    private void dgkh(String sjrq,String filePath) {
        //对公客户-企业
        List<DgkhxxInfo> dgkhxxInfoList = null;
        try {
            dgkhxxInfoList = EasyXlsUtil.saxReadDgkhxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (DgkhxxInfo dgkhxxInfo : dgkhxxInfoList) {
            dgkhxxInfo.setSjrq(sjrq);
            log.info(dgkhxxInfo.toString());
            QueryWrapper<DgkhxxFullInfo> queryWrapper = new QueryWrapper<DgkhxxFullInfo>();
            queryWrapper.eq("khh", dgkhxxInfo.getKhh());
            DgkhxxFullInfo selectOne = dgkhxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                dgkhxxInfoMapper.insert(dgkhxxInfo);
                DgkhxxFullInfo dgkhxxFullInfo = new DgkhxxFullInfo();
                BeanUtil.copyProperties(dgkhxxInfo,dgkhxxFullInfo,true);
                dgkhxxFullInfoMapper.insert(dgkhxxFullInfo);
            } else {
                if(ObjectUtil.isNull(dgkhxxInfo.getYyed()) || (ObjectUtil.isNotNull(selectOne.getYyed()) && !NumberUtil.toStr(selectOne.getYyed()).equals(NumberUtil.toStr(dgkhxxInfo.getYyed())))) {
                    dgkhxxFullInfoMapper.delete(queryWrapper);
                    DgkhxxFullInfo dgkhxxFullInfo = new DgkhxxFullInfo();
                    BeanUtil.copyProperties(dgkhxxInfo,dgkhxxFullInfo,true);
                    dgkhxxFullInfoMapper.insert(dgkhxxFullInfo);
                    dgkhxxInfoMapper.insert(dgkhxxInfo);
                }
            }
        }
    }
    private void ftydkjc(String sjrq,String filePath) {
        List<FtydwdkjcxxInfo> ftydwdkjcxxInfoList = null;
        try {
            ftydwdkjcxxInfoList = EasyXlsUtil.saxReadFtydwdkjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkjcxxInfo ftydwdkjcxxInfo : ftydwdkjcxxInfoList) {
            ftydwdkjcxxInfo.setSjrq(sjrq);
            QueryWrapper<FtydwdkjcxxFullInfo> queryWrapper = new QueryWrapper<FtydwdkjcxxFullInfo>();
            queryWrapper.eq("dkjjbh", ftydwdkjcxxInfo.getDkjjbh());
            FtydwdkjcxxFullInfo selectOne = ftydwdkjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                ftydwdkjcxxInfoMapper.insert(ftydwdkjcxxInfo);
                FtydwdkjcxxFullInfo ftydwdkjcxxFullInfo = new FtydwdkjcxxFullInfo();
                BeanUtil.copyProperties(ftydwdkjcxxInfo,ftydwdkjcxxFullInfo,true);
                ftydwdkjcxxFullInfoMapper.insert(ftydwdkjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getSjzzrq()) && !selectOne.getSjzzrq().equals(ftydwdkjcxxInfo.getSjzzrq())) {
                    ftydwdkjcxxFullInfoMapper.delete(queryWrapper);
                    FtydwdkjcxxFullInfo ftydwdkjcxxFullInfo = new FtydwdkjcxxFullInfo();
                    BeanUtil.copyProperties(ftydwdkjcxxInfo,ftydwdkjcxxFullInfo,true);
                    ftydwdkjcxxFullInfoMapper.insert(ftydwdkjcxxFullInfo);
                    ftydwdkjcxxInfoMapper.insert(ftydwdkjcxxInfo);
                }
            }
        }
    }
    private void ftydkfk(String sjrq,String filePath) {
        List<FtydwdkfkxxInfo> ftydwdkfkxxInfoList = null;
        try {
            ftydwdkfkxxInfoList = EasyXlsUtil.saxReadFtydwdkfkxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkfkxxInfo ftydwdkfkxxInfo : ftydwdkfkxxInfoList) {
            if(StrUtil.isEmpty(ftydwdkfkxxInfo.getJylsh())) {
                ftydwdkfkxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            ftydwdkfkxxInfo.setSjrq(sjrq);
            ftydwdkfkxxInfoMapper.insert(ftydwdkfkxxInfo);
        }
    }
    private void ftydkye(String sjrq,String filePath) {
        List<FtydwdkyexxInfo> ftydwdkyexxInfoList = null;
        try {
            ftydwdkyexxInfoList = EasyXlsUtil.saxReadFtydwdkyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwdkyexxInfo ftydwdkyexxInfo : ftydwdkyexxInfoList) {
            ftydwdkyexxInfo.setSjrq(sjrq);
            QueryWrapper<FtydwdkyexxFullInfo> queryWrapper = new QueryWrapper<FtydwdkyexxFullInfo>();
            queryWrapper.eq("dkjjbh", ftydwdkyexxInfo.getDkjjbh());
            FtydwdkyexxFullInfo selectOne = ftydwdkyexxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                ftydwdkyexxInfoMapper.insert(ftydwdkyexxInfo);
                FtydwdkyexxFullInfo ftydwdkyexxFullInfo = new FtydwdkyexxFullInfo();
                BeanUtil.copyProperties(ftydwdkyexxInfo,ftydwdkyexxFullInfo,true);
                ftydwdkyexxFullInfoMapper.insert(ftydwdkyexxFullInfo);
            } else {
                if(!NumberUtil.toStr(selectOne.getDkye()).equals(NumberUtil.toStr(ftydwdkyexxInfo.getDkye()))) {
                    ftydwdkyexxFullInfoMapper.delete(queryWrapper);
                    FtydwdkyexxFullInfo ftydwdkyexxFullInfo = new FtydwdkyexxFullInfo();
                    BeanUtil.copyProperties(ftydwdkyexxInfo,ftydwdkyexxFullInfo,true);
                    ftydwdkyexxFullInfoMapper.insert(ftydwdkyexxFullInfo);
                    ftydwdkyexxInfoMapper.insert(ftydwdkyexxInfo);
                }
            }
        }
    }
    private void ftyckjc(String sjrq,String filePath) {
        List<FtydwckjcxxInfo> ftydwckjcxxInfoList = null;
        try {
            ftydwckjcxxInfoList = EasyXlsUtil.saxReadFtydwckjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckjcxxInfo ftydwckjcxxInfo : ftydwckjcxxInfoList) {
            ftydwckjcxxInfo.setSjrq(sjrq);
            ftydwckjcxxInfoMapper.insert(ftydwckjcxxInfo);
        }
    }
    private void ftyckfs(String sjrq,String filePath) {
        List<FtydwckfsxxInfo> ftydwckfsxxInfoList = null;
        try {
            ftydwckfsxxInfoList = EasyXlsUtil.saxReadFtydwckfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckfsxxInfo ftydwckfsxxInfo : ftydwckfsxxInfoList) {
            ftydwckfsxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(ftydwckfsxxInfo.getJylsh())) {
                ftydwckfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            ftydwckfsxxInfoMapper.insert(ftydwckfsxxInfo);
        }
    }
    private void ftyckye(String sjrq,String filePath){
        List<FtydwckyexxInfo> ftydwckyexxInfoList = null;
        try {
            ftydwckyexxInfoList = EasyXlsUtil.saxReadFtydwckyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (FtydwckyexxInfo ftydwckyexxInfo : ftydwckyexxInfoList) {
            ftydwckyexxInfo.setSjrq(sjrq);
            ftydwckyexxInfoMapper.insert(ftydwckyexxInfo);
        }
    }

    private void pjtxjc(String sjrq,String filePath) {
        List<PjtxztxjcxxInfo> pjtxztxjcxxInfoList = null;
        try {
            pjtxztxjcxxInfoList = EasyXlsUtil.saxReadPjtxztxjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxjcxxInfo pjtxztxjcxxInfo : pjtxztxjcxxInfoList) {
            pjtxztxjcxxInfo.setSjrq(sjrq);
            pjtxztxjcxxInfoMapper.insert(pjtxztxjcxxInfo);
        }
    }
    private void pjtxfs(String sjrq,String filePath) {
        List<PjtxztxfsxxInfo> pjtxztxfsxxInfoList = null;
        try {
            pjtxztxfsxxInfoList = EasyXlsUtil.saxReadPjtxztxfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxfsxxInfo pjtxztxfsxxInfo : pjtxztxfsxxInfoList) {
            if(StrUtil.isEmpty(pjtxztxfsxxInfo.getJylsh())) {
                pjtxztxfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            pjtxztxfsxxInfo.setSjrq(sjrq);
            pjtxztxfsxxInfoMapper.insert(pjtxztxfsxxInfo);
        }
    }
    private void pjtxye(String sjrq,String filePath){
        List<PjtxztxyexxInfo> pjtxztxyexxInfoList = null;
        try {
            pjtxztxyexxInfoList = EasyXlsUtil.saxReadPjtxztxyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxyexxInfo pjtxztxyexxInfo : pjtxztxyexxInfoList) {
            pjtxztxyexxInfo.setSjrq(sjrq);
            pjtxztxyexxInfoMapper.insert(pjtxztxyexxInfo);
        }
    }

    private void wtdkjc(String sjrq,String filePath) {
        List<WtdkjcxxInfo> wtdkjcxxInfoList = null;
        try {
            wtdkjcxxInfoList = EasyXlsUtil.saxReadWtdkjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkjcxxInfo wtdkjcxxInfo : wtdkjcxxInfoList) {
            wtdkjcxxInfo.setSjrq(sjrq);
            QueryWrapper<WtdkjcxxFullInfo> queryWrapper = new QueryWrapper<WtdkjcxxFullInfo>();
            queryWrapper.eq("dkjjbh", wtdkjcxxInfo.getDkjjbh());
            WtdkjcxxFullInfo selectOne = wtdkjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                wtdkjcxxInfoMapper.insert(wtdkjcxxInfo);
                WtdkjcxxFullInfo wtdkjcxxFullInfo = new WtdkjcxxFullInfo();
                BeanUtil.copyProperties(wtdkjcxxInfo,wtdkjcxxFullInfo,true);
                wtdkjcxxFullInfoMapper.insert(wtdkjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getSjzzrq()) && !selectOne.getSjzzrq().equals(wtdkjcxxInfo.getSjzzrq())) {
                    wtdkjcxxFullInfoMapper.delete(queryWrapper);
                    WtdkjcxxFullInfo wtdkjcxxFullInfo = new WtdkjcxxFullInfo();
                    BeanUtil.copyProperties(wtdkjcxxInfo,wtdkjcxxFullInfo,true);
                    wtdkjcxxFullInfoMapper.insert(wtdkjcxxFullInfo);
                    wtdkjcxxInfoMapper.insert(wtdkjcxxInfo);
                }
            }
        }
    }
    private void wtdkfk(String sjrq,String filePath) {
        List<WtdkfkxxInfo> wtdkfkxxInfoList = null;
        try {
            wtdkfkxxInfoList = EasyXlsUtil.saxReadWtdkfkxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkfkxxInfo wtdkfkxxInfo : wtdkfkxxInfoList) {
            wtdkfkxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(wtdkfkxxInfo.getJylsh())) {
                wtdkfkxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            wtdkfkxxInfoMapper.insert(wtdkfkxxInfo);
        }
    }
    private void wtdkye(String sjrq,String filePath){
        List<WtdkyexxInfo> wtdkyexxInfoList = null;
        try {
            wtdkyexxInfoList = EasyXlsUtil.saxReadWtdkyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (WtdkyexxInfo wtdkyexxInfo : wtdkyexxInfoList) {
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

    private void tyckjc(String sjrq,String filePath) {
        List<TyckjcxxInfo> tyckjcxxInfoList = null;
        try {
            tyckjcxxInfoList = EasyXlsUtil.saxReadTyckjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckjcxxInfo tyckjcxxInfo : tyckjcxxInfoList) {
            tyckjcxxInfo.setSjrq(sjrq);
            QueryWrapper<TyckjcxxFullInfo> queryWrapper = new QueryWrapper<TyckjcxxFullInfo>();
            queryWrapper.eq("ckzhbm", tyckjcxxInfo.getCkzhbm());
            TyckjcxxFullInfo selectOne = tyckjcxxFullInfoMapper.selectOne(queryWrapper);
            if(ObjectUtil.isEmpty(selectOne)) {
                tyckjcxxInfoMapper.insert(tyckjcxxInfo);
                TyckjcxxFullInfo tyckjcxxFullInfo = new TyckjcxxFullInfo();
                BeanUtil.copyProperties(tyckjcxxInfo,tyckjcxxFullInfo,true);
                tyckjcxxFullInfoMapper.insert(tyckjcxxFullInfo);
            } else {
                if(StrUtil.isNotEmpty(selectOne.getDqrq()) && !selectOne.getDqrq().equals(tyckjcxxInfo.getDqrq())) {
                    tyckjcxxFullInfoMapper.delete(queryWrapper);
                    TyckjcxxFullInfo tyckjcxxFullInfo = new TyckjcxxFullInfo();
                    BeanUtil.copyProperties(tyckjcxxInfo,tyckjcxxFullInfo,true);
                    tyckjcxxFullInfoMapper.insert(tyckjcxxFullInfo);
                    tyckjcxxInfoMapper.insert(tyckjcxxInfo);
                }
            }
        }
    }
    private void tyckfs(String sjrq,String filePath) {
        List<TyckfsxxInfo> tyckfsxxInfoList = null;
        try {
            tyckfsxxInfoList = EasyXlsUtil.saxReadTyckfsxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckfsxxInfo tyckfsxxInfo : tyckfsxxInfoList) {
            tyckfsxxInfo.setSjrq(sjrq);
            if(StrUtil.isEmpty(tyckfsxxInfo.getJylsh())) {
                tyckfsxxInfo.setJylsh(IdUtil.getSnowflake().nextIdStr());
            }
            tyckfsxxInfoMapper.insert(tyckfsxxInfo);
        }
    }
    private void tyckye(String sjrq,String filePath){
        List<TyckyexxInfo> tyckyexxInfoList = null;
        try {
            tyckyexxInfoList = EasyXlsUtil.saxReadTyckyexxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (TyckyexxInfo tyckyexxInfo : tyckyexxInfoList) {
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
}
