package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckfsxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwckfsxxInfoListener extends AnalysisEventListener<FtydwckfsxxInfo> {
    private List<FtydwckfsxxInfo> ftydwckfsxxInfoList = new ArrayList<FtydwckfsxxInfo>();
    @Override
    public void invoke(FtydwckfsxxInfo ftydwckfsxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwckfsxxInfoList.add(ftydwckfsxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwckfsxxInfo> getFtydwckfsxxInfoList() {
        return ftydwckfsxxInfoList;
    }

    public void setFtydwckfsxxInfoList(List<FtydwckfsxxInfo> ftydwckfsxxInfoList) {
        this.ftydwckfsxxInfoList = ftydwckfsxxInfoList;
    }
}
