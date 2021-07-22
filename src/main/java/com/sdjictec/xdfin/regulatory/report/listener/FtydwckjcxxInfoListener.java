package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwckjcxxInfoListener extends AnalysisEventListener<FtydwckjcxxInfo> {
    private List<FtydwckjcxxInfo> ftydwckjcxxInfoList = new ArrayList<FtydwckjcxxInfo>();
    @Override
    public void invoke(FtydwckjcxxInfo ftydwckjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwckjcxxInfoList.add(ftydwckjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwckjcxxInfo> getFtydwckjcxxInfoList() {
        return ftydwckjcxxInfoList;
    }

    public void setFtydwckjcxxInfoList(List<FtydwckjcxxInfo> ftydwckjcxxInfoList) {
        this.ftydwckjcxxInfoList = ftydwckjcxxInfoList;
    }
}
