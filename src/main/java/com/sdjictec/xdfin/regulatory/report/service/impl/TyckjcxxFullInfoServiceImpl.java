package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.TyckjcxxFullInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.TyckjcxxFullInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.TyckjcxxFullInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 同业存款基础信息全量表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-23
 */
@Service
@Transactional
public class TyckjcxxFullInfoServiceImpl extends ServiceImpl<TyckjcxxFullInfoMapper, TyckjcxxFullInfo> implements TyckjcxxFullInfoService {

}
