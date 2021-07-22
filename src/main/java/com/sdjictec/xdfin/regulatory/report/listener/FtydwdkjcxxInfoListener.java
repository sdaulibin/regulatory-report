package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwdkjcxxInfoListener extends AnalysisEventListener<FtydwdkjcxxInfo> {
    private List<FtydwdkjcxxInfo> ftydwdkjcxxInfoList = new ArrayList<FtydwdkjcxxInfo>();
    @Override
    public void invoke(FtydwdkjcxxInfo ftydwdkjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwdkjcxxInfoList.add(ftydwdkjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwdkjcxxInfo> getFtydwdkjcxxInfoList() {
        return ftydwdkjcxxInfoList;
    }

    public void setFtydwdkjcxxInfoList(List<FtydwdkjcxxInfo> ftydwdkjcxxInfoList) {
        this.ftydwdkjcxxInfoList = ftydwdkjcxxInfoList;
    }
}
