package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkfkxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkyexxInfo;

/**
 * <p>
 * 非同业单位贷款放款信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface FtydwdkfkxxInfoService extends IService<FtydwdkfkxxInfo> {
    Boolean checkKhh(String khh, String dkjjbh);
    void ftydwdkfkxxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
