package com.bjpowernode.controller;

import com.bjpowernode.entity.Order;
import com.bjpowernode.entity.Product;
import com.bjpowernode.entity.User;
import com.bjpowernode.feign.ProductFeignApi;
import com.bjpowernode.feign.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    private ProductFeignApi productFeignApi;
    @Autowired
    private UserFeignApi userFeignApi;
    @RequestMapping("/save")
    public Order save(Long pid,Long uid,Integer number){
        Order order = new Order();
        order.setNumber(number);
        order.setOid(new Date().getTime());
        //商品数据
        Product product = productFeignApi.getByPid(pid);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        //用户数据
        User user = userFeignApi.getByUid(uid);
        order.setUid(user.getUid());
        order.setUsername(user.getUsername());
        return order;
    }
}
