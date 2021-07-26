package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckfsxxInfo;

/**
 * <p>
 * 非同业单位存款发生额信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface FtydwckfsxxInfoService extends IService<FtydwckfsxxInfo> {
    Boolean checkKhh(String khh, String ckzhbm,String ckxh,String sjrq);
    void ftydwckfsxxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
