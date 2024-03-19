package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_item_details")
public class CartItems {
    @Id
    private String cartEntryId;
    private String orderId;
    private String groceryItemId;
    private int quantity;

    public String getOrderId() {
        return orderId;
    }

    public CartItems() {
    }

    public CartItems(String cartEntryId, String orderId, String groceryItemId, int quantity) {
        this.cartEntryId = cartEntryId;
        this.orderId = orderId;
        this.groceryItemId = groceryItemId;
        this.quantity = quantity;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGroceryItemId() {
        return groceryItemId;
    }

    public void setGroceryItemId(String groceryItemId) {
        this.groceryItemId = groceryItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCartEntryId() {
        return cartEntryId;
    }

    public void setCartEntryId(String cartEntryId) {
        this.cartEntryId = cartEntryId;
    }
}
