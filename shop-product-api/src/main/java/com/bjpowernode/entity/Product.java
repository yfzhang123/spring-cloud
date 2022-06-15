package com.bjpowernode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long pid;
    private String pname;
    private Double pprice;
    private Integer stock;//库存
}
