package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxfsxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PjtxztxfsxxInfoListener extends AnalysisEventListener<PjtxztxfsxxInfo> {
    private List<PjtxztxfsxxInfo> pjtxztxfsxxInfoList = new ArrayList<PjtxztxfsxxInfo>();
    @Override
    public void invoke(PjtxztxfsxxInfo pjtxztxfsxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        pjtxztxfsxxInfoList.add(pjtxztxfsxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<PjtxztxfsxxInfo> getPjtxztxfsxxInfoList() {
        return pjtxztxfsxxInfoList;
    }

    public void setPjtxztxfsxxInfoList(List<PjtxztxfsxxInfo> pjtxztxfsxxInfoList) {
        this.pjtxztxfsxxInfoList = pjtxztxfsxxInfoList;
    }
}
