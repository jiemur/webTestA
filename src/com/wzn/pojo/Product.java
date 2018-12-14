package com.wzn.pojo;

public class Product {
    private int productId;
    private String productName;
    private Double productPrice;
    private String des;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public Product(int productId, String productName, Double productPrice, String des) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.des = des;
    }

    public Product() {
    }
}
