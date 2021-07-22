package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 同业存款基础信息全量表
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TyckjcxxFullInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 存款账户编码
     */
    private String ckzhbm;

    /**
     * 存放业务类型
     */
    private String cfywlx;

    /**
     * 起始日期
     */
    private String qsrq;

    /**
     * 到期日期
     */
    private String dqrq;

    /**
     * 存款期限类型
     */
    private String ckqxlx;

    /**
     * 定价基准类型
     */
    private String djjzlx;

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
     * 利率浮动频率
     */
    private String llfdpl;


}
