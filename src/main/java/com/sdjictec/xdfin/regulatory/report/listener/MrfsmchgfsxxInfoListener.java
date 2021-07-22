package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgfsxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MrfsmchgfsxxInfoListener extends AnalysisEventListener<MrfsmchgfsxxInfo> {
    private List<MrfsmchgfsxxInfo> mrfsmchgfsxxInfoList = new ArrayList<MrfsmchgfsxxInfo>();
    @Override
    public void invoke(MrfsmchgfsxxInfo mrfsmchgfsxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        mrfsmchgfsxxInfoList.add(mrfsmchgfsxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<MrfsmchgfsxxInfo> getMrfsmchgfsxxInfoList() {
        return mrfsmchgfsxxInfoList;
    }

    public void setMrfsmchgfsxxInfoList(List<MrfsmchgfsxxInfo> mrfsmchgfsxxInfoList) {
        this.mrfsmchgfsxxInfoList = mrfsmchgfsxxInfoList;
    }
}
