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

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public boolean addOrder(Order order, Integer contentId, Integer userId) {
        //这里需要考虑使用事务，先查询contentId对应的库存
        Product content = productMapper.selectDetail(contentId);
        if (content.getInventory() > order.getOrderCount()) {
            orderMapper.insert(order, contentId, userId);
            content.setInventory(content.getInventory() - order.getOrderCount());
            productMapper.update(content);
            return true;
        }
        return false;
    }

    public Order getOrder(Integer orderId) {
        return null;
    }

    public List<Order> getOrderList(Integer userId) {
        return orderMapper.selectAllByUserId(userId);
    }

}
