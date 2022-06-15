package com.bjpowernode.feign.fallback;

import com.bjpowernode.entity.User;
import com.bjpowernode.feign.UserFeignApi;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignApi {
    @Override
    public User getByUid(Long uid) {

        User user = new User(-1L, "用户错误", "111111");
        return user;
    }
}
