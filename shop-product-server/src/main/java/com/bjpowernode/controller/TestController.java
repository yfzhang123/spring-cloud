package com.bjpowernode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${appConfig.testconfig}")
    private String myconfig;
    @RequestMapping("/configtest")
    public String test(){
        return myconfig;
    }
}
