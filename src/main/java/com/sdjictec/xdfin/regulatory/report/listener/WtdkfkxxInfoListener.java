package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkfkxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WtdkfkxxInfoListener extends AnalysisEventListener<WtdkfkxxInfo> {
    private List<WtdkfkxxInfo> wtdkfkxxInfoList = new ArrayList<WtdkfkxxInfo>();
    @Override
    public void invoke(WtdkfkxxInfo wtdkfkxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        wtdkfkxxInfoList.add(wtdkfkxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<WtdkfkxxInfo> getWtdkfkxxInfoList() {
        return wtdkfkxxInfoList;
    }

    public void setWtdkfkxxInfoList(List<WtdkfkxxInfo> wtdkfkxxInfoList) {
        this.wtdkfkxxInfoList = wtdkfkxxInfoList;
    }
}
