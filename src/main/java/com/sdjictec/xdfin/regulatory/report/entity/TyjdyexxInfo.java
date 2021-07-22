package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 同业借贷余额信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TyjdyexxInfo implements Serializable {

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
     * 业务编码
     */
    private String ywbm;

    /**
     * 币种
     */
    private String bz;

    /**
     * 余额
     */
    private BigDecimal ye;


}
