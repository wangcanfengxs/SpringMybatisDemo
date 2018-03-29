package com.netease.wcf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netease.wcf.demo.bean.Product;

public interface ProductMapper {
    Integer insert(Product product);
    
    void delete(Integer id);
    
    Product selectDetail(Integer id);
    
    List<Product> selectAllProducts();
    
    List<Product> selectAll();
    
    List<Product> selectIsNotBuy(Integer userId);
    
    List<Product> selectIsBuy(Integer userId);
    
    List<Product> selectIsNotSell(Integer userId);
    
    List<Product> selectIsSell(Integer userId);
    
    int update(Product product);
    
    int setPutOff(@Param("id")int id, @Param("putOff")int putOff);
}
