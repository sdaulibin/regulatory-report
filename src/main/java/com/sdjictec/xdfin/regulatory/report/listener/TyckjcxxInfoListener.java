package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyckjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyckjcxxInfoListener extends AnalysisEventListener<TyckjcxxInfo> {
    private List<TyckjcxxInfo> tyckjcxxInfoList = new ArrayList<TyckjcxxInfo>();
    @Override
    public void invoke(TyckjcxxInfo tyckjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyckjcxxInfoList.add(tyckjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyckjcxxInfo> getTyckjcxxInfoList() {
        return tyckjcxxInfoList;
    }

    public void setTyckjcxxInfoList(List<TyckjcxxInfo> tyckjcxxInfoList) {
        this.tyckjcxxInfoList = tyckjcxxInfoList;
    }
}
