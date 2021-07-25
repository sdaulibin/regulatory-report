package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkyexxInfo;

/**
 * <p>
 * 委托贷款余额信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface WtdkyexxInfoService extends IService<WtdkyexxInfo> {
    Boolean checkJkrkhh(String jkrkhh, String dkjjbh);
    Boolean checkWtrkhh(String wtrkhh, String dkjjbh);
    void wtdkyexxInfoImport(String sjrq,String filePath);
}
