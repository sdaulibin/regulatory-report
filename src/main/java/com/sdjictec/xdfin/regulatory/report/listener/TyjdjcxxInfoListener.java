package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyjdjcxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyjdjcxxInfoListener extends AnalysisEventListener<TyjdjcxxInfo> {
    private List<TyjdjcxxInfo> tyjdjcxxInfoList = new ArrayList<TyjdjcxxInfo>();
    @Override
    public void invoke(TyjdjcxxInfo tyjdjcxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyjdjcxxInfoList.add(tyjdjcxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyjdjcxxInfo> getTyjdjcxxInfoList() {
        return tyjdjcxxInfoList;
    }

    public void setTyjdjcxxInfoList(List<TyjdjcxxInfo> tyjdjcxxInfoList) {
        this.tyjdjcxxInfoList = tyjdjcxxInfoList;
    }
}
