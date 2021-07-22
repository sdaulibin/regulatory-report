package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WtdkjcxxInfoListener extends AnalysisEventListener<WtdkjcxxInfo> {
    private List<WtdkjcxxInfo> wtdkjcxxInfoList = new ArrayList<WtdkjcxxInfo>();
    @Override
    public void invoke(WtdkjcxxInfo wtdkjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        wtdkjcxxInfoList.add(wtdkjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<WtdkjcxxInfo> getWtdkjcxxInfoList() {
        return wtdkjcxxInfoList;
    }

    public void setWtdkjcxxInfoList(List<WtdkjcxxInfo> wtdkjcxxInfoList) {
        this.wtdkjcxxInfoList = wtdkjcxxInfoList;
    }
}
