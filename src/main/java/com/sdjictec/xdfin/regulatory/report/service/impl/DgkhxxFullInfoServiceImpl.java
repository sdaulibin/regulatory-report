package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.DgkhxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.DgkhxxFullInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 对公客户信息全量表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Service
@Transactional
public class DgkhxxFullInfoServiceImpl extends ServiceImpl<DgkhxxFullInfoMapper, DgkhxxFullInfo> implements DgkhxxFullInfoService {

}
