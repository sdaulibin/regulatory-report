package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwdkyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwdkyexxInfoListener extends AnalysisEventListener<FtydwdkyexxInfo> {
    private List<FtydwdkyexxInfo> ftydwdkyexxInfoList = new ArrayList<FtydwdkyexxInfo>();
    @Override
    public void invoke(FtydwdkyexxInfo ftydwdkyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwdkyexxInfoList.add(ftydwdkyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwdkyexxInfo> getFtydwdkyexxInfoList() {
        return ftydwdkyexxInfoList;
    }

    public void setFtydwdkyexxInfoList(List<FtydwdkyexxInfo> ftydwdkyexxInfoList) {
        this.ftydwdkyexxInfoList = ftydwdkyexxInfoList;
    }
}
