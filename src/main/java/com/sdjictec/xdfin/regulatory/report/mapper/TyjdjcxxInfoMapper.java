package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.TyjdjcxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 同业借贷基础信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface TyjdjcxxInfoMapper extends BaseMapper<TyjdjcxxInfo> {
    List<String> getContactStr(String sjrq);
}
