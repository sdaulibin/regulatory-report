package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.MrfsmchgjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MrfsmchgjcxxInfoListener extends AnalysisEventListener<MrfsmchgjcxxInfo> {
    private List<MrfsmchgjcxxInfo> mrfsmchgjcxxInfoList = new ArrayList<MrfsmchgjcxxInfo>();
    @Override
    public void invoke(MrfsmchgjcxxInfo mrfsmchgjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        mrfsmchgjcxxInfoList.add(mrfsmchgjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<MrfsmchgjcxxInfo> getMrfsmchgjcxxInfoList() {
        return mrfsmchgjcxxInfoList;
    }

    public void setMrfsmchgjcxxInfoList(List<MrfsmchgjcxxInfo> mrfsmchgjcxxInfoList) {
        this.mrfsmchgjcxxInfoList = mrfsmchgjcxxInfoList;
    }
}
