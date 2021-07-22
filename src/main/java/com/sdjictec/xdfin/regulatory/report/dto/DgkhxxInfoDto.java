package com.sdjictec.xdfin.regulatory.report.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 对公客户信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DgkhxxInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收集日期
     */
    private String sjrq;

    /**
     * 客户号
     */
    @ExcelProperty(index = 0,value = "名称")
    @ColumnWidth(30)
    @Length(max = 10)
    private String khh;

    /**
     * 内部机构号
     */
    private String nbjgh;

    /**
     * 国民经济部门分类
     */
    private String gmjjbmfl;

    /**
     * 金融机构类型代码
     */
    private String jrjglxdm;

    /**
     * 企业规模
     */
    private String qygm;

    /**
     * 控股类型
     */
    private String kglx;

    /**
     * 境内境外标志
     */
    private String jnjwbz;

    /**
     * 经营所在地行政区划代码
     */
    private String jyszdxzqhdm;

    /**
     * 注册地址
     */
    private String zcdz;

    /**
     * 授信额度
     */
    private BigDecimal sxed;

    /**
     * 已用额度
     */
    private BigDecimal yyed;

    /**
     * 所属行业
     */
    private String sshy;

    /**
     * 农村城市标志
     */
    private String nccsbz;


}
