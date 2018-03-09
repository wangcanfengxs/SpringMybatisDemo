package com.netease.wcf.demo.dao;

import java.util.List;

import com.netease.wcf.demo.bean.Product;

public interface ProductMapper {
    Integer insert(Product content);
    
    void delete(Integer id);
    
    Product selectDetail(Integer id);
    
    List<Product> selectAll();
    
    int update(Product content);
}
