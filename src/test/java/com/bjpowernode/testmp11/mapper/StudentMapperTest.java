package com.bjpowernode.testmp11.mapper;

import com.bjpowernode.testmp11.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    void testSelectByName(){
        List<Student> zhangsan = studentMapper.selectByName("zhangsan");

        System.out.println(zhangsan);
    }
}