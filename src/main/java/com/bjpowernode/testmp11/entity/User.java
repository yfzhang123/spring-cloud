package com.bjpowernode.testmp11.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
   @TableId(value = "id",type = IdType.AUTO)
  private Integer id;
  private String name;
  private String email;
  private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
