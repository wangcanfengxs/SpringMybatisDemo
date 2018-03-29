package com.netease.wcf.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.service.ProductService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session, HttpServletRequest request) {
        LOGGER.info("index page.");
        // 登陆跳转，需要获取到用户信息
        User user = (User)session.getAttribute("user");
        // 获取产品信息
        List<Product> productList = productService.getProductList(user);
        model.addAttribute("productList", productList);
        return "index";
    }
    
    @RequestMapping(value= "/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value= "/logout", method=RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
      
    @RequestMapping(value= "/publish", method=RequestMethod.GET)
    public String publish(){
        return "publish";
    }
    
    @RequestMapping(value="/cart", method=RequestMethod.GET)
    public String cart(){
        return "cart";
    }
    
}
