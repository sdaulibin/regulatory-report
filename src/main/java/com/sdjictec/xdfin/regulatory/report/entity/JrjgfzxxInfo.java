package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 金融机构分支信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JrjgfzxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 金融机构名称
     */
    private String jrjgmc;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 统一社会信用代码
     */
    private String tyshxydm;

    /**
     * 直属上级机构号
     */
    private String zssjjgh;

    /**
     * 直属上级机构名称
     */
    private String zssjjgmc;

    /**
     * 地区代码
     */
    private String dqdm;

    /**
     * 机构级别
     */
    private String jgjb;


}
