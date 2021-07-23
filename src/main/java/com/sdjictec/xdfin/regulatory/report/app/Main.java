package com.sdjictec.xdfin.regulatory.report.app;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.sdjictec.xdfin.regulatory.report.entity.DgkhxxInfo;
import com.sdjictec.xdfin.regulatory.report.util.EasyXlsUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(IdUtil.getSnowflake().nextIdStr());
        System.out.println(FileUtil.getLineSeparator());
        System.out.println(DateUtil.parse("1997/1/1").toString("yyyy-MM-dd"));
    }
}
