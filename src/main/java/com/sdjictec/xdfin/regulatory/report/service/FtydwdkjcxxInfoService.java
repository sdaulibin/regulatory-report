package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkyexxInfo;

/**
 * <p>
 * 非同业单位贷款基础信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface FtydwdkjcxxInfoService extends IService<FtydwdkjcxxInfo> {
    Boolean checkKhh(String khh);
    void ftydwdkjcxxInfoImport(String sjrq, String filePath);
    int deleteBysjrq(String sjrq);
}
