package com.bjpowernode.testmp11.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@TableName(value = "person")
public class MyPerson extends Model<MyPerson> {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String personName;
    private Integer personAge;
    @TableField(value = "tel")
    private String telephone;

    @Override
    public String toString() {
        return "MyPerson{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
