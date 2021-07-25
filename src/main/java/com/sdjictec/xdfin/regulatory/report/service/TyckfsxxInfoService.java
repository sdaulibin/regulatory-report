package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.TyckfsxxInfo;

/**
 * <p>
 * 同业存款发生额信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface TyckfsxxInfoService extends IService<TyckfsxxInfo> {
    public Boolean checkKhh(String khh, String ckzhbm);
    void tyckfsxxInfoImport(String sjrq,String filePath);
}
