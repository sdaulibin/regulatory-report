package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.WtdkyexxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WtdkyexxInfoListener extends AnalysisEventListener<WtdkyexxInfo> {
    private List<WtdkyexxInfo> wtdkyexxInfoList = new ArrayList<WtdkyexxInfo>();
    @Override
    public void invoke(WtdkyexxInfo wtdkyexxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        wtdkyexxInfoList.add(wtdkyexxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<WtdkyexxInfo> getWtdkyexxInfoList() {
        return wtdkyexxInfoList;
    }

    public void setWtdkyexxInfoList(List<WtdkyexxInfo> wtdkyexxInfoList) {
        this.wtdkyexxInfoList = wtdkyexxInfoList;
    }
}
