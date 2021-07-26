package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckyexxInfo;

/**
 * <p>
 * 非同业单位存款余额新表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface FtydwckyexxInfoService extends IService<FtydwckyexxInfo> {
    Boolean checkKhh(String khh, String ckzhbm,String ckxh,String sjrq);
    void ftydwckyexxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
