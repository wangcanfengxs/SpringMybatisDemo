package com.netease.wcf.demo.service;

import com.netease.wcf.demo.bean.User;

public interface UserService {
    User login(String username, String password);
}
