package com.netease.wcf.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.dao.ProductMapper;
import com.netease.wcf.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProductList(Integer userId) {
        //查询所有的产品
        List<Product> productList = productMapper.selectAll();
        //查询用户已购买的产品
        List<Product> buyProductList;
        return null;
    }
}
