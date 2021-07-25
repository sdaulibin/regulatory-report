package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.WtdkjcxxFullInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 委托贷款基础信息全量表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Service
@Transactional
public class WtdkjcxxFullInfoServiceImpl extends ServiceImpl<WtdkjcxxFullInfoMapper, WtdkjcxxFullInfo> implements WtdkjcxxFullInfoService {

}
