package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkfkxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwdkfkxxInfoListener extends AnalysisEventListener<FtydwdkfkxxInfo> {
    private List<FtydwdkfkxxInfo> ftydwdkfkxxInfoList = new ArrayList<FtydwdkfkxxInfo>();
    @Override
    public void invoke(FtydwdkfkxxInfo ftydwdkfkxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwdkfkxxInfoList.add(ftydwdkfkxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwdkfkxxInfo> getFtydwdkfkxxInfoList() {
        return ftydwdkfkxxInfoList;
    }

    public void setFtydwdkfkxxInfoList(List<FtydwdkfkxxInfo> ftydwdkfkxxInfoList) {
        this.ftydwdkfkxxInfoList = ftydwdkfkxxInfoList;
    }
}
