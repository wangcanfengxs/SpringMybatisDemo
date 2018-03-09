package com.netease.wcf.demo.bean;

public class Product {

    private Integer productId; // 内容编号，主键
    private String title; // 标题
    private String digest; // 摘要
    private String image; // 图片
    private Integer price; // 当前价格
    private String detail; // 全文，详细内容
    private Integer inventory; // 库存，保留字段，不作处理

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Integer getInventory() {
        return inventory;
    }
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", title=" + title + ", digest=" + digest + ", image=" + image + ", price=" + price + ", detail=" + detail + ", inventory="
                + inventory + "]";
    }

}
