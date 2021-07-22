package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 非同业单位贷款余额信息全量表
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FtydwdkyexxFullInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 贷款借据编号
     */
    private String dkjjbh;

    /**
     * 客户号
     */
    private String khh;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 币种
     */
    private String bz;

    /**
     * 贷款余额
     */
    private BigDecimal dkye;


}
