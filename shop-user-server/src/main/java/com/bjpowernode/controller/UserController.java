package com.bjpowernode.controller;

import com.bjpowernode.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user/{uid}")
    public User getByUid(@PathVariable("uid") Long uid){
        User user = new User();
        user.setUid(uid);
        user.setUsername("用户"+uid);
        user.setPassword("666666");
        return user;
    }
}
