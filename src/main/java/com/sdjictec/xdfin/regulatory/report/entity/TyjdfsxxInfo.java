package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 同业借贷发生额信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TyjdfsxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 业务编码
     */
    private String ywbm;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 客户号
     */
    private String khh;

    /**
     * 交易流水号
     */
    private String jylsh;

    /**
     * 交易日期
     */
    private String jyrq;

    /**
     * 币种
     */
    private String bz;

    /**
     * 实际利率
     */
    private BigDecimal sjll;

    /**
     * 基准利率
     */
    private BigDecimal jzll;

    /**
     * 发生金额
     */
    private BigDecimal fsje;

    /**
     * 交易方向
     */
    private String jyfx;


}
