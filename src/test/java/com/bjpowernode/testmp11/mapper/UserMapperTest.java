package com.bjpowernode.testmp11.mapper;

import com.bjpowernode.testmp11.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void test(){
        userMapper.insert(new User(null,"admin3","bb@qq.com",11));
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setEmail("aaaaa");
        int root = userMapper.updateById(user);
        System.out.println(root);
    }
    @Test
    void testdelete(){
        int ret=userMapper.deleteById(2);
        System.out.println(ret);

    }
    @Test
    void testdeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        /**
         * map中所有设置的条件之间是and关系
         */
        map.put("name","admin");
        map.put("age",11);
        int map1 = userMapper.deleteByMap(map);
        System.out.println(map1);
    }
    @Test
    void testBatchDelete(){
        List<Integer> collect = Stream.of(4,6).collect(Collectors.toList());
        int i = userMapper.deleteBatchIds(collect);
        System.out.println(i);
    }
    @Test
    void testselectByid(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    void testselect(){
        List<Integer> collect = Stream.of(1, 5).collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(collect);
        System.out.println(users);
    }
    @Test
    void testSelectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","admin1");
        map.put("age",11);
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }
}
