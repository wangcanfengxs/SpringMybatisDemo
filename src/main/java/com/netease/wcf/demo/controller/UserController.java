package com.netease.wcf.demo.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.service.UserService;
import com.netease.wcf.demo.util.Response;

@Controller
public class UserController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    public Response doLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session){
        LOGGER.debug("user login username:" + userName + ",password:" + password) ;
        
        User user = userService.login(userName, password);
        Response message = null;
        if(user == null){
            message = new Response("用户名或密码错误",false,500);
        }else{
            message = new Response("",true,200);
            //将User信息保存到session中
            session.setAttribute("user", user);
        }
        return message;
    }
}
