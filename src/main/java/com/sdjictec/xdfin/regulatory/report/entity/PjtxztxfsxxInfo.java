package com.sdjictec.xdfin.regulatory.report.entity;

import com.sdjictec.xdfin.regulatory.report.util.ExcelDateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 票据贴现及转贴现发生额信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PjtxztxfsxxInfo implements Serializable {

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
     * 交易流水号
     */
    private String jylsh;

    /**
     * 币种
     */
    private String bz;

    /**
     * 交易日期
     */
    private String jyrq;

    /**
     * 发生金额
     */
    private BigDecimal fsje;

    /**
     * 贴现利率
     */
    private BigDecimal txll;

    /**
     * 交易方向
     */
    private String jyfx;

    public String getJyrq() {
        return ExcelDateUtil.getDateStr(jyrq);
    }
}
