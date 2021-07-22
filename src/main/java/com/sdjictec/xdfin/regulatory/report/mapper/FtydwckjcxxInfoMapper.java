package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  非同业单位存款基础信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface FtydwckjcxxInfoMapper extends BaseMapper<FtydwckjcxxInfo> {
    List<String> getContactStr(String sjrq);
}
