package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgfsxxInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.MrfsmchgfsxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.MrfsmchgfsxxInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 买入返售及卖出回购发生额信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Service
@Transactional
public class MrfsmchgfsxxInfoServiceImpl extends ServiceImpl<MrfsmchgfsxxInfoMapper, MrfsmchgfsxxInfo> implements MrfsmchgfsxxInfoService {

}
