package com.sdjictec.xdfin.regulatory.report.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.entity.TyjdfsxxInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TyjdfsxxInfoListener extends AnalysisEventListener<TyjdfsxxInfo> {
    private List<TyjdfsxxInfo> tyjdfsxxInfoList = new ArrayList<TyjdfsxxInfo>();
    @Override
    public void invoke(TyjdfsxxInfo tyjdfsxxInfo, AnalysisContext context) {
//        System.out.println(esbData.toString());
        tyjdfsxxInfoList.add(tyjdfsxxInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<TyjdfsxxInfo> getTyjdfsxxInfoList() {
        return tyjdfsxxInfoList;
    }

    public void setTyjdfsxxInfoList(List<TyjdfsxxInfo> tyjdfsxxInfoList) {
        this.tyjdfsxxInfoList = tyjdfsxxInfoList;
    }
}
