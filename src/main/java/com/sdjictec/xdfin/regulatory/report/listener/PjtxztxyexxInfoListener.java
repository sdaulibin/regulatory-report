package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PjtxztxyexxInfoListener extends AnalysisEventListener<PjtxztxyexxInfo> {
    private List<PjtxztxyexxInfo> pjtxztxyexxInfoList = new ArrayList<PjtxztxyexxInfo>();
    @Override
    public void invoke(PjtxztxyexxInfo pjtxztxyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        pjtxztxyexxInfoList.add(pjtxztxyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<PjtxztxyexxInfo> getPjtxztxyexxInfoList() {
        return pjtxztxyexxInfoList;
    }

    public void setPjtxztxyexxInfoList(List<PjtxztxyexxInfo> pjtxztxyexxInfoList) {
        this.pjtxztxyexxInfoList = pjtxztxyexxInfoList;
    }
}
