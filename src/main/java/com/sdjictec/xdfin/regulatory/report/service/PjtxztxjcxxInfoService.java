package com.sdjictec.xdfin.regulatory.report.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxjcxxInfo;

/**
 * <p>
 * 票据贴现及转贴现基础信息表 服务类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
public interface PjtxztxjcxxInfoService extends IService<PjtxztxjcxxInfo> {
    Boolean checkKhh(String khh,String pjrzywlx);
    void pjtxztxjcxxInfoImport(String sjrq,String filePath);
    int deleteBysjrq(String sjrq);
}
