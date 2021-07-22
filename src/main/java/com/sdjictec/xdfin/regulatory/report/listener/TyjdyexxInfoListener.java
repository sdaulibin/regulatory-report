package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyjdyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyjdyexxInfoListener extends AnalysisEventListener<TyjdyexxInfo> {
    private List<TyjdyexxInfo> tyjdyexxInfoList = new ArrayList<TyjdyexxInfo>();
    @Override
    public void invoke(TyjdyexxInfo tyjdyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyjdyexxInfoList.add(tyjdyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyjdyexxInfo> getTyjdyexxInfoList() {
        return tyjdyexxInfoList;
    }

    public void setTyjdyexxInfoList(List<TyjdyexxInfo> tyjdyexxInfoList) {
        this.tyjdyexxInfoList = tyjdyexxInfoList;
    }
}
