package com.bjpowernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/sentinel2")
    public String sentinel2(){
        return "sentinel2";
    }
    @RequestMapping("/sentinel3")
    public String sentinel3(){
        return "sentinel3";
    }
    @RequestMapping("/vipres")
    public  String vipres(){
        return "vipres";
    }
    @RequestMapping("/comres")
    public  String comres(){
        return "comres";
    }
}
