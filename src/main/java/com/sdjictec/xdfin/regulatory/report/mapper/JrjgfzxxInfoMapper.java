package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.JrjgfzxxInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 金融机构分支信息表 Mapper 接口
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Mapper
public interface JrjgfzxxInfoMapper extends BaseMapper<JrjgfzxxInfo> {
    List<String> getContactStr(String sjrq);
}
