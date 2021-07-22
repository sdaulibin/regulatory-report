package com.sdjictec.xdfin.regulatory.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdjictec.xdfin.regulatory.report.entity.ColumnEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lengleng
 * @date 2020/5/18
 */
@Mapper
public interface GenTableColumnMapper extends BaseMapper<ColumnEntity> {

	/**
	 * 查询表全部列信息
	 * @param tableName
	 * @param dsName
	 * @return
	 */
	List<ColumnEntity> selectTableColumn(@Param("tableName") String tableName, @Param("dsName") String dsName);

	/**
	 * 查询表全部列信息
	 * @param tableName 表名称
	 * @param dsName 数据源名称
	 * @return
	 */
	List<Map<String, String>> selectMapTableColumn(@Param("tableName") String tableName, String dsName);

}
