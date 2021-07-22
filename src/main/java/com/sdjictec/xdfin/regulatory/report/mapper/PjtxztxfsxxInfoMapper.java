package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxfsxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 票据贴现及转贴现发生额信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface PjtxztxfsxxInfoMapper extends BaseMapper<PjtxztxfsxxInfo> {
    List<String> getContactStr(String sjrq);
}
