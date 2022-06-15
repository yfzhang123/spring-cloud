package com.bjpowernode.feign;

import com.bjpowernode.entity.Product;
import com.bjpowernode.feign.fallback.ProductFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service",fallback = ProductFeignFallback.class)
public interface ProductFeignApi {
    @RequestMapping("/product/{pid}")
    Product getByPid(@PathVariable("pid") Long pid);
}
