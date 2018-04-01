package com.netease.wcf.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.dao.ProductMapper;
import com.netease.wcf.demo.dao.OrderMapper;
import com.netease.wcf.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public boolean addOrders(List<Order> orders) {
        for (Order order : orders) {
            orderMapper.insert(order);
        }
        return true;
    }

    public Order getOrder(Integer orderId) {
        return orderMapper.selectDetail(orderId);
    }

    public List<Order> getOrderList(Integer userId) {
        return orderMapper.selectAllByUserId(userId);
    }

}
