package com.bjpowernode.testmp11;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.Driver;

public class MyGenerator {
    public static void main(String[] args) {
        //mp中自动生成代码的对象
        AutoGenerator ag=new AutoGenerator();
        //全局设置
        GlobalConfig globalConfig = new GlobalConfig();
        String property = System.getProperty("user.dir");
       // System.out.println(property);
        //指定文件输出路径
        globalConfig.setOutputDir(property+"/src/main/java");
        //设置生成类命名规则
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        globalConfig.setAuthor("yf");
        //设置主键
        globalConfig.setIdType(IdType.AUTO);
        ag.setGlobalConfig(globalConfig);
        //设置数据源
        DataSourceConfig ds = new DataSourceConfig();
        ds.setDriverName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/testmp11gen?useUnicode=true&characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("123456");
        ag.setDataSource(ds);
        //设置包信息
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.bjpowernode");
        pc.setModuleName("testmp11");
        ag.setPackageInfo(pc);
        //设置 策略  如驼峰
        StrategyConfig sc = new StrategyConfig();
        //表名驼峰
        sc.setNaming(NamingStrategy.underline_to_camel);
        //列名  下划线
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        ag.setStrategy(sc);
        ag.execute();
    }
}
