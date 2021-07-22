package com.sdjictec.xdfin.regulatory.report;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.sdjictec.xdfin.regulatory.report.mapper")
@SpringBootApplication
public class RegulatoryReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegulatoryReportApplication.class, args);
    }

}
