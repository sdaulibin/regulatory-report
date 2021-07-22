package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgjcxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 买入返售及卖出回购基础信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface MrfsmchgjcxxInfoMapper extends BaseMapper<MrfsmchgjcxxInfo> {
    List<String> getContactStr(String sjrq);
}
