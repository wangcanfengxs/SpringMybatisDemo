package com.netease.wcf.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.netease.wcf.demo.bean.User;

@Component
public interface UserMapper {
    
    /**
     * 根据用户名和密码查询用户是否存在
     * @param username
     * @param password
     * @return
     */
    User selectUser(@Param("username") String username,@Param("password")String password);
    
    
}
