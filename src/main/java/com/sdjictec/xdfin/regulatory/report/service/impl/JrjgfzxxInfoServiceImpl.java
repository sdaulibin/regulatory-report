package com.sdjictec.xdfin.regulatory.report.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdjictec.xdfin.regulatory.report.entity.JrjgfzxxInfo;
import com.sdjictec.xdfin.regulatory.report.mapper.JrjgfzxxInfoMapper;
import com.sdjictec.xdfin.regulatory.report.service.JrjgfzxxInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 金融机构分支信息表 服务实现类
 * </p>
 *
 * @author binginx
 * @since 2021-07-22
 */
@Service
@Transactional
public class JrjgfzxxInfoServiceImpl extends ServiceImpl<JrjgfzxxInfoMapper, JrjgfzxxInfo> implements JrjgfzxxInfoService {

}
