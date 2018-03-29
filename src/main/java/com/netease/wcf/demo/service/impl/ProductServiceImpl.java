package com.netease.wcf.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.dao.OrderMapper;
import com.netease.wcf.demo.dao.ProductMapper;
import com.netease.wcf.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    public ModelAndView getProduct(User user, Integer productId) {

        ModelAndView mv = new ModelAndView();
        if (user == null || user.getUserRole().equals(User.SELLER) ) {
            Product product = productMapper.selectDetail(productId);
            mv.addObject("product", product);
        } else if (user.getUserRole().equals(User.BUYER)) {
            Order order = orderMapper.selectByUserIdAndProductId(user.getUserId(), productId);
            if (order != null) {
                mv.addObject("orderPrice", order.getOrderPrice());
                mv.addObject("orderCount", order.getOrderCount());
                mv.addObject("product", order.getProduct());
            }else{
                Product product = productMapper.selectDetail(productId);
                mv.addObject("product", product);
            }
        } 

        return mv;
    }

    public List<Product> getProductsByUser(Integer userId) {
        return productMapper.selectIsBuy(userId);
    }

    public List<Product> getProductList(User user) {

        List<Product> productList = new ArrayList<Product>();

        if (user == null) {
            // 获取所有商品
            productList.addAll(productMapper.selectAll());
        } else if (user.getUserRole().equals(User.BUYER)) {
            // 查询未购买商品
            {
                List<Product> productIsNotBuy = productMapper.selectIsNotBuy(user.getUserId());
                for (Product product : productIsNotBuy) {
                    product.setBuy(false);
                }
                productList.addAll(productIsNotBuy);
                LOGGER.debug("product is not buy:" + productIsNotBuy);
            }
            // 查询已购买商品
            {
                List<Product> productIsBuy = productMapper.selectIsBuy(user.getUserId());
                for (Product product : productIsBuy) {
                    product.setBuy(true);
                }
                productList.addAll(productIsBuy);
                LOGGER.debug("product is buy:" + productIsBuy);
            }
        } else if (user.getUserRole().equals(User.SELLER)) {
            List<Product> products = productMapper.selectAllProducts();
            productList.addAll(products);
            
//            // 查询未售出商品
//            {
//                List<Product> productIsNotSell = productMapper.selectIsNotSell(user.getUserId());
//                for (Product product : productIsNotSell) {
//                    product.setSell(false);
//                }
//                productList.addAll(productIsNotSell);
//                LOGGER.debug("product is not sell:" + productIsNotSell);
//            }
//            // 查询已售出商品
//            {
//                List<Product> productIsSell = productMapper.selectIsSell(user.getUserId());
//                for (Product product : productIsSell) {
//                    product.setSell(true);
//                }
//                productList.addAll(productIsSell);
//                LOGGER.debug("product is sell:" + productIsSell);
//            }
        }
        return productList;
    }

    public int saveProduct(Product product) {
        return productMapper.insert(product);
    }

    public int putOffProduct(Integer productId) {
        return productMapper.setPutOff(productId, 1);
    }
    
    public int updateProduct(Product product){
        return productMapper.update(product);
    }

}
