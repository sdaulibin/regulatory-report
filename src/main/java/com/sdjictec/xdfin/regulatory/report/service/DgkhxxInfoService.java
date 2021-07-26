package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.util.ExcelCheckManager;

/**
 * <p>
 * 对公客户信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface DgkhxxInfoService extends ExcelCheckManager<DgkhxxInfo> {
    DgkhxxFullInfo getByHhh(String khh);
    void dgkhxxImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
