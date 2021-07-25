package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkyexxFullInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.WtdkyexxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.WtdkyexxFullInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 委托贷款余额信息全量表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Service
@Transactional
public class WtdkyexxFullInfoServiceImpl extends ServiceImpl<WtdkyexxFullInfoMapper, WtdkyexxFullInfo> implements WtdkyexxFullInfoService {

}
