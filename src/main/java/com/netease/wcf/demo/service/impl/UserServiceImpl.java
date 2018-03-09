package com.netease.wcf.demo.service.impl;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.dao.UserMapper;
import com.netease.wcf.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private HashMap<Integer, User> userCache = new HashMap<Integer, User>();
    
    @Autowired
    private UserMapper userMapper;
    
    public User login(String username, String password) {   
        return userMapper.selectUser(username, password); 
    }
    
    public User getUser(HttpServletRequest request){
        Integer userId = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("userid".equals(cookie.getName())){
                userId = Integer.valueOf(cookie.getName());
                break;
            }
        }
    }

}
