package com.sdjictec.xdfin.regulatory.report.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

public class ExcelDateUtil {
    public static String getDateStr(String date) {
        if (StrUtil.isNotEmpty(date)) {
            try {
                return DateUtil.parse(date).toString("yyyy-MM-dd").toString();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

}
