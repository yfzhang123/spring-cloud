package com.bjpowernode.testmp11.mapper;

import com.bjpowernode.testmp11.entity.MyPerson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MyPersonMapperTest {
    @Test
    void testSelect(){
        MyPerson myPerson = new MyPerson();
        List<MyPerson> myPeople = myPerson.selectAll();
        System.out.println(myPeople);
    }

}