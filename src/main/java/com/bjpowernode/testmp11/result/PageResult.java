package com.bjpowernode.testmp11.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PageResult<T> {
    private List<T> data;//当前页数据
    private Long currentPage;//当前页
    private Long pageSize;//一页显示几条数据
    private Long totalCount;//总条数
    private Long totalPage;//总页数
    private Long nextPage;//下一页
    private Long prePage;//上一页
}
