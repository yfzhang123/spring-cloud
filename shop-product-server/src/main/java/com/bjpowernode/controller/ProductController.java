package com.bjpowernode.controller;

import com.bjpowernode.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping("/product/{pid}")
    public Product getById(@PathVariable("pid") Long pid){
        Product product = new Product();
        product.setPid(pid);
        product.setPname("商品"+pid);
        product.setPprice((double)(pid*10));
        product.setStock(10);
        return product;

    }
}
