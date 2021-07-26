package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxInfo;

/**
 * <p>
 * 委托贷款基础信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface WtdkjcxxInfoService extends IService<WtdkjcxxInfo> {
    Boolean checkJkrkhh(String jkrkhh);
    Boolean checkWtrkhh(String wtkhh);
    void wtdkjcxxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
