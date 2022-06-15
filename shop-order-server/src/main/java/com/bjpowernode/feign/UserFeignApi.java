package com.bjpowernode.feign;

import com.bjpowernode.entity.User;
import com.bjpowernode.feign.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service",fallback = UserFeignFallback.class)
public interface UserFeignApi {
    @RequestMapping("/user/{uid}")
    User getByUid(@PathVariable("uid") Long uid);
}
