package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 对公客户信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface DgkhxxInfoMapper extends BaseMapper<DgkhxxInfo> {
    List<DgkhxxInfo> getDgkhxxInfoList(String sjrq);

    List<String> getContactStr(String sjrq);

    DgkhxxInfo getKhh(String khh);
}
