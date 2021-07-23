package com.sdjictec.xdfin.regulatory.report.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.sdjictec.xdfin.regulatory.report.util.CustomStringStringConverter;
import com.sdjictec.xdfin.regulatory.report.util.ExcelDateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *  非同业单位存款基础信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FtydwckjcxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 存款账户编码
     */
    private String ckzhbm;

    /**
     * 存款序号
     */
    private String ckxh;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 客户号
     */
    private String khh;

    /**
     * 存款产品类别
     */
    private String ckcplb;

    /**
     * 协议存款类型
     */
    private String xycklb;

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

    /**
     * 保底收益率
     */
    private BigDecimal bdsyl;

    /**
     * 最高收益率
     */
    private BigDecimal zgsyl;

    /**
     * 开户渠道
     */
    private String khqd;

    /**
     * 异地存款标志
     */
    private String ydckbz;

    /**
     * 大小额标志
     */
    private String dxebz;

    /*public void setQsrq(String qsrq) {
        this.qsrq = ExcelDateUtil.getDateStr(qsrq);
    }

    public void setDqrq(String dqrq) {
        this.dqrq = ExcelDateUtil.getDateStr(dqrq);
    }

    public void setSjzzrq(String sjzzrq) {
        this.sjzzrq = ExcelDateUtil.getDateStr(sjzzrq);
    }*/

    public String getQsrq() {
        return ExcelDateUtil.getDateStr(qsrq);
    }

    public String getDqrq() {
        return ExcelDateUtil.getDateStr(dqrq);
    }

    public String getSjzzrq() {
        return ExcelDateUtil.getDateStr(sjzzrq);
    }
}
