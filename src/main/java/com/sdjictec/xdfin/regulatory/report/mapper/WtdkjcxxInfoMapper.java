package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 委托贷款基础信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface WtdkjcxxInfoMapper extends BaseMapper<WtdkjcxxInfo> {
    List<String> getContactStr(String sjrq);
}
