package com.sdjictec.xdfin.regulatory.report.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxInfoService;
import com.sdjictec.xdfin.regulatory.report.util.ExcelCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 对公客户信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Service
public class DgkhxxInfoServiceImpl implements DgkhxxInfoService {
    @Autowired
    private DgkhxxInfoMapper dgkhxxInfoMapper;

    @Override
    public ExcelCheckResult checkImportExcel(List<DgkhxxInfo> dgkhxxInfoList) {
        for (DgkhxxInfo dgkhxxInfo:dgkhxxInfoList) {
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
        return null;
    }
}
