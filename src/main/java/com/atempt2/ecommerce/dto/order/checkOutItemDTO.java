package com.atempt2.ecommerce.dto.order;


public class checkOutItemDTO {
    private  String productName;
    private int quantity;
    private double price;
    private long product_id;
    private long user_idp;

    public checkOutItemDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getUser_idp() {
        return user_idp;
    }

    public void setUser_idp(long user_idp) {
        this.user_idp = user_idp;
    }
}
