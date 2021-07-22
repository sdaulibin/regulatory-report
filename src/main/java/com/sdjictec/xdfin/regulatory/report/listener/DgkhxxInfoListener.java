package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DgkhxxInfoListener extends AnalysisEventListener<DgkhxxInfo> {
    private List<DgkhxxInfo> dgkhxxList = new ArrayList<DgkhxxInfo>();
    @Override
    public void invoke(DgkhxxInfo dgkhxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        dgkhxxList.add(dgkhxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<DgkhxxInfo> getDgkhxxList() {
        return dgkhxxList;
    }

    public void setDgkhxxList(List<DgkhxxInfo> dgkhxxList) {
        this.dgkhxxList = dgkhxxList;
    }
}
