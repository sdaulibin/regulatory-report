package com.sdjictec.xdfin.regulatory.report.entity;

import com.sdjictec.xdfin.regulatory.report.util.ExcelDateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 票据贴现及转贴现基础信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PjtxztxjcxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 客户号
     */
    private String khh;

    /**
     * 金融机构类型代码
     */
    private String jrjglxdm;

    /**
     * 业务编码
     */
    private String ywbm;

    /**
     * 票据融资业务类型
     */
    private String pjrzywlx;

    /**
     * 起始日期
     */
    private String qsrq;

    /**
     * 到期日期
     */
    private String dqrq;

    /**
     * 票据融资期限类型
     */
    private String pjrzqxlx;

    /**
     * 贴现利率
     */
    private BigDecimal txll;

    /**
     * 币种
     *//*
    private String bz;

    *//**
     * 业务类型
     *//*
    private String ywlx;*/

    public String getQsrq() {
        return ExcelDateUtil.getDateStr(qsrq);
    }

    public String getDqrq() {
        return ExcelDateUtil.getDateStr(dqrq);
    }
}
