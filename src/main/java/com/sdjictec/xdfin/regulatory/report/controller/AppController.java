package com.sdjictec.xdfin.regulatory.report.controller;

import com.sdjictec.xdfin.regulatory.report.service.impl.DeleteDataService;
import com.sdjictec.xdfin.regulatory.report.service.impl.GenerateDataService;
import com.sdjictec.xdfin.regulatory.report.service.impl.TransDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xidianfin")
public class AppController {
    @Autowired
    private TransDataService transDataService;
    @Autowired
    private GenerateDataService generateDataService;
    @Autowired
    private DeleteDataService deleteDataService;

    @RequestMapping(value = "/transData/{sjrq}", method = RequestMethod.GET)
    @ResponseBody
    public String transData(@PathVariable("sjrq") String sjrq) {
        transDataService.tranData(sjrq.replaceAll("-",""),sjrq);
        return "success";
    }

    @RequestMapping(value = "/genData/{sjrq}", method = RequestMethod.GET)
    @ResponseBody
    public String genData(@PathVariable("sjrq") String sjrq) {
        generateDataService.generateData(sjrq.replaceAll("-",""),sjrq);
        return "success";
    }

    @RequestMapping(value = "/deleteData/{sjrq}", method = RequestMethod.GET)
    @ResponseBody
    public int deleteData(@PathVariable("sjrq") String sjrq) {
        return deleteDataService.deleteData(sjrq);
    }

    @RequestMapping(value = "/all/{sjrq}", method = RequestMethod.GET)
    @ResponseBody
    public String allIn(@PathVariable("sjrq") String sjrq) {
        deleteDataService.deleteData(sjrq);
        transDataService.tranData(sjrq.replaceAll("-",""),sjrq);
        generateDataService.generateData(sjrq.replaceAll("-",""),sjrq);
        return "success";
    }
}
