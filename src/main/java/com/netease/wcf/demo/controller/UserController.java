package com.netease.wcf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public void login(String username, String password){
        User user = userService.getUser(username, password);
        if(user == null){
            
        }
    }
}
