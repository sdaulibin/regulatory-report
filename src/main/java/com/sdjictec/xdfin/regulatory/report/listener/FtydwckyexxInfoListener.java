package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.FtydwckyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FtydwckyexxInfoListener extends AnalysisEventListener<FtydwckyexxInfo> {
    private List<FtydwckyexxInfo> ftydwckyexxInfoList = new ArrayList<FtydwckyexxInfo>();
    @Override
    public void invoke(FtydwckyexxInfo ftydwckyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        ftydwckyexxInfoList.add(ftydwckyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<FtydwckyexxInfo> getFtydwckyexxInfoList() {
        return ftydwckyexxInfoList;
    }

    public void setFtydwckyexxInfoList(List<FtydwckyexxInfo> ftydwckyexxInfoList) {
        this.ftydwckyexxInfoList = ftydwckyexxInfoList;
    }
}
