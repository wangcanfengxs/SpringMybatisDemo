package com.netease.wcf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    public void addOrder(@RequestBody Order order, @PathVariable("contentId") Integer contentId){
       
        //boolean result = orderService.addOrder(order, contentId, userId);
        
    }
    
}
