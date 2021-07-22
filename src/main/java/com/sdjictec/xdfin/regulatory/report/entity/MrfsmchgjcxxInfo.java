package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 买入返售及卖出回购基础信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MrfsmchgjcxxInfo implements Serializable {

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
     * 回购业务类型
     */
    private String hgywlx;

    /**
     * 标的物类型
     */
    private String bdwlx;

    /**
     * 起始日期
     */
    private String qsrq;

    /**
     * 到期日期
     */
    private String dqrq;

    /**
     * 实际终止日期
     */
    private String sjzzrq;

    /**
     * 回购期限类型
     */
    private String hgqxlx;

    /**
     * 借贷定价基准类型
     */
    private String jddjjzlx;

    /**
     * 利率类型
     */
    private String lllx;

    /**
     * 实际利率
     */
    private BigDecimal sjll;

    /**
     * 基准利率
     */
    private BigDecimal jzll;

    /**
     * 计息方式
     */
    private String jxfs;

    /**
     * 利率浮动频率
     */
    private String llfdpl;


}
