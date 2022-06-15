package com.bjpowernode.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TraceServiceImpl {
    //定义一个sentinel资源，controller中的对外接口（@RequestMapping）时默认资源，其他资源需要使用@SentinelResource注解定义
    @SentinelResource(value = "importantRes")
    public String  importantRes(){
        System.out.println("important resource");
        return "important resource";
    }
}
