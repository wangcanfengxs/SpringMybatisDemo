package com.netease.wcf.demo.service;

import java.util.List;

import com.netease.wcf.demo.bean.Order;

public interface OrderService {
    
    /**
     * 增加订单，需要考虑事务
     * @param order 订单详情
     * @param contentId 订单内容编号
     * @param userId 用户编号
     * @return
     */
    boolean addOrder(Order order, Integer contentId, Integer userId);
    
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
