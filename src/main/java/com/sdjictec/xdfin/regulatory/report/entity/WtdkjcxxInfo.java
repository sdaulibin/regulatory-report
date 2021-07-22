package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 委托贷款基础信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WtdkjcxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 贷款合同编码
     */
    private String dkhtbm;

    /**
     * 贷款借据编号
     */
    private String dkjjbh;

    /**
     * 借款人客户号
     */
    private String jkrkhh;

    /**
     * 委托人客户号
     */
    private String wtrkhh;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 贷款发放日期
     */
    private String dkffrq;

    /**
     * 原始到期日期
     */
    private String ysdqrq;

    /**
     * 实际终止日期
     */
    private String sjzzrq;

    /**
     * 贷款期限类型
     */
    private String dkqxlx;

    /**
     * 利率类型
     */
    private String lllx;

    /**
     * 定价基准类型
     */
    private String djjzlx;

    /**
     * 基准利率
     */
    private BigDecimal jzll;

    /**
     * 实际利率
     */
    private BigDecimal sjll;

    /**
     * 利率浮动频率
     */
    private String llfdpl;

    /**
     * 贷款实际投向
     */
    private String dksjtx;


}
