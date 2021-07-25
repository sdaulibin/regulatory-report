package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.TyjdjcxxInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.TyjdjcxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.TyjdjcxxInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 同业借贷基础信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Service
@Transactional
public class TyjdjcxxInfoServiceImpl extends ServiceImpl<TyjdjcxxInfoMapper, TyjdjcxxInfo> implements TyjdjcxxInfoService {

}
