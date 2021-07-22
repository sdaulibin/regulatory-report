package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.JrjgfrxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JrjgfrxxInfoListener extends AnalysisEventListener<JrjgfrxxInfo> {
    private List<JrjgfrxxInfo> jrjgfrxxInfoList = new ArrayList<JrjgfrxxInfo>();
    @Override
    public void invoke(JrjgfrxxInfo jrjgfrxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        jrjgfrxxInfoList.add(jrjgfrxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<JrjgfrxxInfo> getJrjgfrxxInfoList() {
        return jrjgfrxxInfoList;
    }

    public void setJrjgfrxxInfoList(List<JrjgfrxxInfo> jrjgfrxxInfoList) {
        this.jrjgfrxxInfoList = jrjgfrxxInfoList;
    }
}
