package com.bjpowernode.testmp11.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.testmp11.entity.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectByName(String name);
}
