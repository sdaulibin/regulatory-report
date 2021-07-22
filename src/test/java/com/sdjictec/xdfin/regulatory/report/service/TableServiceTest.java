package com.sdjictec.xdfin.regulatory.report.service;

import com.sdjictec.xdfin.regulatory.report.mapper.GenTableColumnMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableServiceTest {
    @Autowired
    private GenTableColumnMapper genTableColumnMapper;
    @Test
    public void getColunms() {
        String tableStr = "dgkhxx_info,ftydwckfsxx_info,ftydwckjcxx_info,ftydwckyexx_info,ftydwdkfkxx_info,ftydwdkjcxx_info,ftydwdkyexx_info,jrjgfrxx_info,jrjgfzxx_info,mrfsmchgfsxx_info,mrfsmchgjcxx_info,mrfsmchgyexx_info,pjtxztxfsxx_info,pjtxztxjcxx_info,pjtxztxyexx_info,tyckfsxx_info,tyckjcxx_info,tyckyexx_info,tyjdfsxx_info,tyjdjcxx_info,tyjdyexx_info,wtdkfkxx_info,wtdkjcxx_info,wtdkyexx_info";
        String[] tableNames = tableStr.split(",");
        for (int i = 0; i < tableNames.length; i++) {
            List<Map<String, String>> mapTableColumn = genTableColumnMapper.selectMapTableColumn(tableNames[i], "report");
            StringBuffer stringBuffer = new StringBuffer("select concat(");
            for (Map<String,String> map: mapTableColumn) {
                stringBuffer.append("IFNULL(").append(map.get("columnName")).append(",'')").append(",'|@|',");
            }
            stringBuffer.append(") from ").append(tableNames[i]);
            log.info(stringBuffer.toString().replace(",'|@|',)",")"));
        }
    }
}
