package com.bjpowernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/fallback1")
    public String fallback1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fallback1";
    }
    int counter=0;
    @RequestMapping("/fallback2")
    public String fallback2(){
        if(++counter%3==0){
            throw new RuntimeException();
        }
        return "fallback2";
    }
    @RequestMapping("/fallback3")
    public  String fallback3(String key){
        if(key!=null && key!=""){
            throw new RuntimeException();
        }
        return "fallback3";
    }
}
