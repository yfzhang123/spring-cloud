package com.bjpowernode.testmp11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjpowernode.testmp11.mapper")
public class Testmp11Application {

    public static void main(String[] args) {
        SpringApplication.run(Testmp11Application.class, args);
    }

}
