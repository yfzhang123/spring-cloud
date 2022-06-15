package com.bjpowernode.feign.fallback;

import com.bjpowernode.entity.Product;
import com.bjpowernode.feign.ProductFeignApi;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallback implements ProductFeignApi {
    @Override
    public Product getByPid(Long pid) {
        Product product = new Product(-1l, "商品错误", 0.0, 10);
        return product;
    }
}
