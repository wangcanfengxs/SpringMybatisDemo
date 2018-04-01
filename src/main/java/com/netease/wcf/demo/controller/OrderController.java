package com.netease.wcf.demo.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.netease.wcf.demo.bean.Order;
import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.service.OrderService;
import com.netease.wcf.demo.util.Response;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 账务功能：显示所有已购买的内容
     * 
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> buyList = orderService.getOrderList(user.getUserId());
        model.addAttribute("buyList", buyList);
        return "account";
    }
    
    /**
     * 购物车下订单
     * @param data
     * @return
     */
    @RequestMapping(value="/api/buy", method=RequestMethod.POST)
    @ResponseBody
    public Response makeOrder(@RequestBody String data, HttpSession session){
        User user = (User)session.getAttribute("user");
        
        System.out.println("orders:" + data);
        JSONArray arrays = JSONArray.parseArray(data);
        List<Order> orders = new ArrayList<Order>();
        int size = arrays.size();
        for(int i = 0; i < size; i++){
            Order order = new Order();
            order.setOrderTime(new Timestamp(System.currentTimeMillis()));
            order.setOrderPrice(arrays.getJSONObject(i).getInteger("price"));
            order.setOrderCount(arrays.getJSONObject(i).getInteger("number"));
            order.setProductId(arrays.getJSONObject(i).getInteger("id"));;
            order.setUserId(user.getUserId());
            orders.add(order);
        }
        
        orderService.addOrders(orders);
        
        return new Response("make order success.", true, 200);
    }
}
