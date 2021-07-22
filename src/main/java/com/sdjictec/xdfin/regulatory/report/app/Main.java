package com.sdjictec.xdfin.regulatory.report.app;

import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        List<DgkhxxInfo> dgkhxxList = EasyXlsUtil.saxReadDgkhxxInfo("/Users/binginx/Downloads/西电财务公司/西电财司利率报备2021.6.27/对公客户信息表-20210627-企业.xlsx");
        for (DgkhxxInfo dgkhxxInfo:dgkhxxList) {
            log.info(dgkhxxInfo.toString());
        }
    }
}
