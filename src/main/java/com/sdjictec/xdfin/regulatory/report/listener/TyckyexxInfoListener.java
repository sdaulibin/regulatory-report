package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyckyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyckyexxInfoListener extends AnalysisEventListener<TyckyexxInfo> {
    private List<TyckyexxInfo> tyckyexxInfoList = new ArrayList<TyckyexxInfo>();
    @Override
    public void invoke(TyckyexxInfo tyckyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyckyexxInfoList.add(tyckyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyckyexxInfo> getTyckyexxInfoList() {
        return tyckyexxInfoList;
    }

    public void setTyckyexxInfoList(List<TyckyexxInfo> tyckyexxInfoList) {
        this.tyckyexxInfoList = tyckyexxInfoList;
    }
}
