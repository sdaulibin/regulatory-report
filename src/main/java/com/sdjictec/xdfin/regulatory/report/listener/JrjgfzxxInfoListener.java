package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.JrjgfzxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JrjgfzxxInfoListener extends AnalysisEventListener<JrjgfzxxInfo> {
    private List<JrjgfzxxInfo> jrjgfzxxInfoList = new ArrayList<JrjgfzxxInfo>();
    @Override
    public void invoke(JrjgfzxxInfo jrjgfzxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        jrjgfzxxInfoList.add(jrjgfzxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<JrjgfzxxInfo> getJrjgfzxxInfoList() {
        return jrjgfzxxInfoList;
    }

    public void setJrjgfzxxInfoList(List<JrjgfzxxInfo> jrjgfzxxInfoList) {
        this.jrjgfzxxInfoList = jrjgfzxxInfoList;
    }
}
