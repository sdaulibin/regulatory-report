package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 委托贷款放款信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WtdkfkxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

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
     * 发生金额
     */
    private BigDecimal fsje;

    /**
     * 基准利率
     */
    private BigDecimal jzll;

    /**
     * 实际利率
     */
    private BigDecimal sjll;


}
