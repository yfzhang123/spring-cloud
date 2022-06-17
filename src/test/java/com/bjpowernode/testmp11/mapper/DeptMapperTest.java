package com.bjpowernode.testmp11.mapper;

import com.bjpowernode.testmp11.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptMapperTest {
    @Test
    void testARInsert(){
        Dept dep = new Dept(null, "zhangsan", "1350377", 1);
        boolean insert = dep.insert();
        System.out.println(insert);
    }
    @Test
    void testARUpdate(){
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("研发部");
        boolean b = dept.updateById();
        System.out.println(b);
    }
    @Test
    void testARDelete(){
        Dept dept = new Dept();
        dept.setId(1);
        boolean b = dept.deleteById();
        System.out.println(b);
    }
    @Test
    void testARSelect(){
        Dept dept = new Dept();
        Dept dept1 = dept.selectById(2);
        System.out.println(dept1);
    }

}