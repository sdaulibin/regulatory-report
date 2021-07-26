package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxyexxInfo;

/**
 * <p>
 * 票据贴现及转贴现余额信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface PjtxztxyexxInfoService extends IService<PjtxztxyexxInfo> {
    Boolean checkKhh(String khh, String ywbm,String sjrq);
    void pjtxztxyexxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
