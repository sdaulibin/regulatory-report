package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MrfsmchgyexxInfoListener extends AnalysisEventListener<MrfsmchgyexxInfo> {
    private List<MrfsmchgyexxInfo> mrfsmchgyexxInfoList = new ArrayList<MrfsmchgyexxInfo>();
    @Override
    public void invoke(MrfsmchgyexxInfo mrfsmchgyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        mrfsmchgyexxInfoList.add(mrfsmchgyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<MrfsmchgyexxInfo> getMrfsmchgyexxInfoList() {
        return mrfsmchgyexxInfoList;
    }

    public void setMrfsmchgyexxInfoList(List<MrfsmchgyexxInfo> mrfsmchgyexxInfoList) {
        this.mrfsmchgyexxInfoList = mrfsmchgyexxInfoList;
    }
}
