package com.bjpowernode.entity;

import lombok.Data;

@Data
public class Order {
    private Long oid;
    private Long  uid;
    private String username;
    private Long pid;
    private String pname;
    private Double pprice;
    private Integer number;//购买数量
}
