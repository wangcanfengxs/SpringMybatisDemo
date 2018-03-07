package com.netease.wcf.demo.bean;

public class User {
    private Integer userId; // 用户Id
    private String userName; // 用户昵称
    private Integer userRole; // 用户角色，买家还是卖家
    private String password; // 密码
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getUserRole() {
        return userRole;
    }
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + ", password=" + password + "]";
    }
}
