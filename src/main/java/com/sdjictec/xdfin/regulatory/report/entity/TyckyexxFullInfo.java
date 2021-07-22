package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 同业存款余额信息全量表
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TyckyexxFullInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 存款账户编码
     */
    private String ckzhbm;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 客户号
     */
    private String khh;

    /**
     * 币种
     */
    private String bz;

    /**
     * 余额
     */
    private BigDecimal ye;


}
