package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.listener.PjtxztxjcxxInfoListener;
import com.sdjictec.xdfin.regulatory.report.mapper.PjtxztxjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.service.PjtxztxjcxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 票据贴现及转贴现基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Slf4j
@Service
@Transactional
public class PjtxztxjcxxInfoServiceImpl extends ServiceImpl<PjtxztxjcxxInfoMapper, PjtxztxjcxxInfo> implements PjtxztxjcxxInfoService {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    private PjtxztxjcxxInfoMapper pjtxztxjcxxInfoMapper;

    @Override
    public Boolean checkKhh(String khh, String pjrzywlx) {
        if(StrUtil.startWith(pjrzywlx,"A")) {
            if(StrUtil.isEmpty(khh)) {
                return false;
            }
            DgkhxxFullInfo dgkhxxFullInfo = dgkhxxInfoService.getByHhh(khh);
            return ObjectUtil.isNotEmpty(dgkhxxFullInfo) ? true : false;
        }
        return true;
    }
    @Override
    public void pjtxztxjcxxInfoImport(String sjrq,String filePath) {
        List<PjtxztxjcxxInfo> pjtxztxjcxxInfoList = null;
        try {
            pjtxztxjcxxInfoList = this.saxReadPjtxztxjcxxInfo(filePath);
        } catch (IOException e) {
            log.error("读取失败:{}", e.getMessage());
        }
        for (PjtxztxjcxxInfo pjtxztxjcxxInfo : pjtxztxjcxxInfoList) {
            if (!this.checkKhh(pjtxztxjcxxInfo.getKhh(),pjtxztxjcxxInfo.getPjrzywlx())) {
                log.error("数据出现问题:{},{}",pjtxztxjcxxInfo.getKhh(),pjtxztxjcxxInfo.getPjrzywlx());
            }
            pjtxztxjcxxInfo.setSjrq(sjrq);
            pjtxztxjcxxInfoMapper.insert(pjtxztxjcxxInfo);
        }
    }

    //票据贴现基础
    public static List<PjtxztxjcxxInfo> saxReadPjtxztxjcxxInfo(String pathFile) throws IOException {
        PjtxztxjcxxInfoListener pjtxztxjcxxInfoListener = new PjtxztxjcxxInfoListener();
        ExcelReader excelReader = EasyExcel.read(pathFile, PjtxztxjcxxInfo.class, pjtxztxjcxxInfoListener).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
        return pjtxztxjcxxInfoListener.getPjtxztxjcxxInfoList();
    }

    @Override
    public int deleteBysjrq(String sjrq) {
        QueryWrapper<PjtxztxjcxxInfo> queryWrapper = new QueryWrapper<PjtxztxjcxxInfo>();
        queryWrapper.eq("sjrq", sjrq);
        return pjtxztxjcxxInfoMapper.delete(queryWrapper);
    }
}
