package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
@Entity
@Table(name="order_details")
public class Order {
    @Id
    private String orderId;
    private String userId;
    private String orderStatus;

    private ArrayList<CartItems> cartItems;

    public Order() {
    }

    public Order(String orderId, String userId, String orderStatus, ArrayList<CartItems> cartItems) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.cartItems = cartItems;
    }

    public ArrayList<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
