package com.netease.wcf.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Response makeOrder(@RequestBody String data){
        System.out.println("products:" + data);
        //TODO
        return new Response("make order success.", true, 200);
    }
}
