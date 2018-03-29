package com.netease.wcf.demo.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.bean.User;

public interface ProductService {
    
    /**
     * 获取商品列表
     * @param userId
     * @return
     */
    List<Product> getProductList(User user);
    
    ModelAndView getProduct(User user, Integer productId);
    
    List<Product> getProductsByUser(Integer userId);
    
    int saveProduct(Product product);
    
    int putOffProduct(Integer productId);
    
    int updateProduct(Product product);
}
