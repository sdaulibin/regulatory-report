package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.TyckjcxxInfo;

/**
 * <p>
 * 同业存款基础信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface TyckjcxxInfoService extends IService<TyckjcxxInfo> {
    public Boolean checkKhh(String khh);
    void tyckjcxxInfoImport(String sjrq,String filePath);
}
