package com.netease.wcf.demo.service;

import java.util.List;

import com.netease.wcf.demo.bean.Order;

public interface OrderService {
    
    /**
     * 增加订单，需要考虑事务
     * @param orders 购物车列表
     * @return
     */
    boolean addOrders(List<Order> orders);
    
    /**
     * 查询订单
     * @param orderId
     * @return
     */
    Order getOrder(Integer orderId);
    
    /**
     * 查询订单列表
     * @param userId
     * @return
     */
    List<Order> getOrderList(Integer userId);
    
    
}
