package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.PjtxztxjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PjtxztxjcxxInfoListener extends AnalysisEventListener<PjtxztxjcxxInfo> {
    private List<PjtxztxjcxxInfo> pjtxztxjcxxInfoList = new ArrayList<PjtxztxjcxxInfo>();
    @Override
    public void invoke(PjtxztxjcxxInfo pjtxztxjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        pjtxztxjcxxInfoList.add(pjtxztxjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<PjtxztxjcxxInfo> getPjtxztxjcxxInfoList() {
        return pjtxztxjcxxInfoList;
    }

    public void setPjtxztxjcxxInfoList(List<PjtxztxjcxxInfo> pjtxztxjcxxInfoList) {
        this.pjtxztxjcxxInfoList = pjtxztxjcxxInfoList;
    }
}
