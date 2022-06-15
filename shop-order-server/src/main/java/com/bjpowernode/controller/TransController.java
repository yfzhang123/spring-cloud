package com.bjpowernode.controller;

import com.bjpowernode.service.TraceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransController {
    @Autowired
    private TraceServiceImpl traceService;
    @RequestMapping("/trace1")
    public String trace1(){
        return traceService.importantRes();
    }
    @RequestMapping("/trace2")
    public String trace2(){
        return traceService.importantRes();
    }

}
