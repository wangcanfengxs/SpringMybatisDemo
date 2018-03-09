package com.netease.wcf.demo.service;

import java.util.List;

import com.netease.wcf.demo.bean.Product;

public interface ProductService {
    
    List<Product> getProductList(Integer userId);
}
