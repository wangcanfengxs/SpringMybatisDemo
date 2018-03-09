package com.netease.wcf.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.service.ProductService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        LOGGER.info("index page.");
        ModelAndView mv = new ModelAndView();
        // 登陆跳转，需要获取到用户信息
        Integer userId = 1;
        //mv.addObject("user", null);
        // 获取产品信息
        List<Product> productList = productService.getProductList(userId);
        mv.addObject("productList", productList);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        LOGGER.info("welcome.");
        System.out.println("welcome wcf.");
        mv.setViewName("welcome");
        return mv;
    }

}
