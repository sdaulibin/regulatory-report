package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyckfsxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyckfsxxInfoListener extends AnalysisEventListener<TyckfsxxInfo> {
    private List<TyckfsxxInfo> tyckfsxxInfoList = new ArrayList<TyckfsxxInfo>();
    @Override
    public void invoke(TyckfsxxInfo tyckfsxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyckfsxxInfoList.add(tyckfsxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyckfsxxInfo> getTyckfsxxInfoList() {
        return tyckfsxxInfoList;
    }

    public void setTyckfsxxInfoList(List<TyckfsxxInfo> tyckfsxxInfoList) {
        this.tyckfsxxInfoList = tyckfsxxInfoList;
    }
}
