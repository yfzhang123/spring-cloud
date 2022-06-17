package com.bjpowernode.testmp11.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.testmp11.entity.Student;
import com.bjpowernode.testmp11.result.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentMapperWrapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testAllEq(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("age",29);
        map.put("name","wangwu");
        qw.allEq(map);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);

    }
    @Test
    public void testAllEqNull(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("age",null);
        map.put("name","wangwu");
        qw.allEq(map,false);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);

    }

    @Test
    public void testEq(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
       qw.eq("name","lisi");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);

    }
    @Test
    public void testNEq(){
        QueryWrapper<Student> qw=new QueryWrapper<>();
        qw.ne("name","lisi");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);

    }
    @Test
    public void testGt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.gt("age",18);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testBetwwen(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.between(true,"age",29,32);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testNotBet(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.notBetween(true,"age",29,32);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testLike(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.like("name","李");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }

    @Test
    public void testLikeleft(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.likeLeft(true,"name","明");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testisnull(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.isNull("email");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testIn(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.in("name","zhangsan","lisi");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testIn2(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        ArrayList<String> lis = new ArrayList<>();
        lis.add("zhangsan");
        lis.add("lisi");

        qw.in("name",lis);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testInsql(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.inSql(true,"name","select name from student where age > 30");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testGroupby(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.groupBy(true,"status");
        qw.select("status,count(*),avg(age)");
        List<Map<String, Object>> maps = studentMapper.selectMaps(qw);
        System.out.println(maps);

    }
    @Test
    public void testOrderby(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.orderByAsc("convert(name using gbk)","age");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testor(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name","lisi").or().gt("age",20);
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);

    }
    @Test
    public void testLast(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name","lisi").or().gt("age",20)
                .last("limit 1");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testExsit(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.gt("age",32);
        qw.exists("select id from student where age=32");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    //分页查询
    @Test
    void testPage(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.orderByAsc("age");
        IPage<Student> page = new Page<>();
        //当前是第几页
        page.setCurrent(3);

        //一页显示几条数据
        page.setSize(4);
        IPage<Student> studentIPage = studentMapper.selectPage(page, qw);
        System.out.println(studentIPage.getRecords());
        System.out.println("当前页："+studentIPage.getCurrent());
        System.out.println("总页数："+studentIPage.getPages());
        System.out.println("每页条数："+studentIPage.getSize());
        System.out.println("总条数："+studentIPage.getTotal());
        PageResult<Student> pr = new PageResult<>();
        pr.setCurrentPage(studentIPage.getCurrent());
        pr.setData(studentIPage.getRecords());
        pr.setPageSize(studentIPage.getSize());
        pr.setTotalCount(studentIPage.getTotal());
        pr.setTotalPage(studentIPage.getPages());
        pr.setNextPage(studentIPage.getCurrent()==studentIPage.getPages()?studentIPage.
                getCurrent():studentIPage.getCurrent()+1);
        pr.setPrePage(studentIPage.getCurrent()==1?1:studentIPage.getCurrent()-1);

    }


}