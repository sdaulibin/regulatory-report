package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgfsxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 买入返售及卖出回购发生额信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface MrfsmchgfsxxInfoMapper extends BaseMapper<MrfsmchgfsxxInfo> {
    List<String> getContactStr(String sjrq);
}
