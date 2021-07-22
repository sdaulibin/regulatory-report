package com.sdjictec.xdfin.regulatory.report.app;

import cn.hutool.core.util.IdUtil;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(IdUtil.getSnowflake().nextIdStr());
    }
}
