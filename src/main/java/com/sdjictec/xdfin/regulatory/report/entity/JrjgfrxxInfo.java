package com.sdjictec.xdfin.regulatory.report.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 金融机构法人信息表
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JrjgfrxxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据日期
     */
    private String sjrq;

    /**
     * 金融机构名称
     */
    private String jrjgmc;

    /**
     * 统一社会信用代码
     */
    private String tyshxydm;

    /**
     * 金融机构编码
     */
    private String jrjgbm;

    /**
     * 金融机构类型代码
     */
    private String jrjglxdm;

    /**
     * 控股类型
     */
    private String kglx;

    /**
     * 企业规模
     */
    private String qygm;

    /**
     * 地区代码
     */
    private String dqdm;

    /**
     * 牵头部门
     */
    private String qtbm;

    /**
     * 牵头部门联系人
     */
    private String qtbmlxr;

    /**
     * 牵头部门联系电话
     */
    private String qtbmlxdh;


}
