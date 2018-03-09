package com.netease.wcf.demo.bean;

import java.sql.Timestamp;

public class Order {
    private Integer orderId; // 订单编号，主键
    // private Date orderTime; // 购买时间
    private Timestamp orderTime;
    private Integer orderPrice; // 购买价格
    private Integer orderCount;// 购买数量
    // private Integer contentId; // 内容编号，外键
    private Integer userId;// 用户Id，外键
    private Product product;
    // private User user;
    public Order() {
        super();
    }

    public Order(Timestamp orderTime, Integer orderPrice, Integer orderCount) {
        super();
        this.orderTime = orderTime;
        this.orderPrice = orderPrice;
        this.orderCount = orderCount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Timestamp getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }
    public Integer getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }
    public Integer getOrderCount() {
        return orderCount;
    }
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
    // public Integer getContentId() {
    // return contentId;
    // }
    // public void setContentId(Integer contentId) {
    // this.contentId = contentId;
    // }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderTime=" + orderTime + ", orderPrice=" + orderPrice + ", orderCount=" + orderCount + ", userId=" + userId + ", product="
                + product + "]";
    }

}
