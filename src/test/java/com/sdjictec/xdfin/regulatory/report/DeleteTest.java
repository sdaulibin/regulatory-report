package com.sdjictec.xdfin.regulatory.report;

import com.sdjictec.xdfin.regulatory.report.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {
    @Autowired
    private DgkhxxInfoService dgkhxxInfoService;
    @Autowired
    private FtydwckfsxxInfoService ftydwckfsxxInfoService;
    @Autowired
    private FtydwckjcxxInfoService ftydwckjcxxInfoService;
    @Autowired
    private FtydwckyexxInfoService ftydwckyexxInfoService;
    @Autowired
    private FtydwdkfkxxInfoService ftydwdkfkxxInfoService;
    @Autowired
    private FtydwdkjcxxInfoService ftydwdkjcxxInfoService;
    @Autowired
    private FtydwdkyexxInfoService ftydwdkyexxInfoService;
    @Autowired
    private JrjgfrxxInfoService jrjgfrxxInfoService;
    @Autowired
    private JrjgfzxxInfoService jrjgfzxxInfoService;
    @Autowired
    private MrfsmchgfsxxInfoService mrfsmchgfsxxInfoService;
    @Autowired
    private MrfsmchgjcxxInfoService mrfsmchgjcxxInfoService;
    @Autowired
    private MrfsmchgyexxInfoService mrfsmchgyexxInfoService;
    @Autowired
    private PjtxztxfsxxInfoService pjtxztxfsxxInfoService;
    @Autowired
    private PjtxztxjcxxInfoService pjtxztxjcxxInfoService;
    @Autowired
    private PjtxztxyexxInfoService pjtxztxyexxInfoService;
    @Autowired
    private TyckfsxxInfoService tyckfsxxInfoService;
    @Autowired
    private TyckjcxxInfoService tyckjcxxInfoService;
    @Autowired
    private TyckyexxInfoService tyckyexxInfoService;
    @Autowired
    private TyjdfsxxInfoService tyjdfsxxInfoService;
    @Autowired
    private TyjdjcxxInfoService tyjdjcxxInfoService;
    @Autowired
    private TyjdyexxInfoService tyjdyexxInfoService;
    @Autowired
    private WtdkfkxxInfoService wtdkfkxxInfoService;
    @Autowired
    private WtdkjcxxInfoService wtdkjcxxInfoService;
    @Autowired
    private WtdkyexxInfoService wtdkyexxInfoService;
    @Test
    public void deleteTest() {
        String sjrq = "2021-06-28";
        int ressult = 0;
        ressult = dgkhxxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwckfsxxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwckyexxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwckjcxxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwdkfkxxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwdkyexxInfoService.deleteBysjrq(sjrq);
        ressult = ftydwdkjcxxInfoService.deleteBysjrq(sjrq);
        ressult = pjtxztxfsxxInfoService.deleteBysjrq(sjrq);
        ressult = pjtxztxyexxInfoService.deleteBysjrq(sjrq);
        ressult = pjtxztxjcxxInfoService.deleteBysjrq(sjrq);
        ressult = tyckfsxxInfoService.deleteBysjrq(sjrq);
        ressult = tyckyexxInfoService.deleteBysjrq(sjrq);
        ressult = tyckjcxxInfoService.deleteBysjrq(sjrq);
        ressult = wtdkfkxxInfoService.deleteBysjrq(sjrq);
        ressult = wtdkyexxInfoService.deleteBysjrq(sjrq);
        ressult = wtdkjcxxInfoService.deleteBysjrq(sjrq);
        log.info("result{}",ressult);
    }
}
