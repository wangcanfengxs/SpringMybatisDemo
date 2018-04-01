package com.netease.wcf.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netease.wcf.demo.bean.Order;

public interface OrderMapper {
    
    /**
     * 插入一个订单
     * @param order 订单
     * @param contentId 商品Id
     * @param userId 用户Id
     * @return
     */
    Integer insert(@Param("order") Order order);

    /**
     * 查询某用户的所有订单
     * @param userId 用户Id
     * @return
     */
    List<Order> selectAllByUserId(Integer userId);
    
    /**
     * 查询订单详情
     * @param orderId 订单Id
     * @return
     */
    Order selectDetail(Integer orderId);
    
    /**
     * 查询用户购买某商品的订单
     * @param orderId
     * @param productId
     * @return
     */
    Order selectByUserIdAndProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);
}
