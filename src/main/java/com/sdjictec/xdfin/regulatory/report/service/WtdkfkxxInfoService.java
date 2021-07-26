package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkfkxxInfo;

/**
 * <p>
 * 委托贷款放款信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface WtdkfkxxInfoService extends IService<WtdkfkxxInfo> {
    Boolean checkJkrkhh(String jkrkhh, String dkjjbh);
    Boolean checkWtrkhh(String wtrkhh, String dkjjbh);
    void wtdkfkxxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
