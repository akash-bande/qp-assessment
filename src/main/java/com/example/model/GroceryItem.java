package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grocery_items")
public class GroceryItem {
    @Id
    private String itemId;
    private String itemName;
    private int itemPrice;
    private int itemAvailableStock;
    private String itemMeasuringUnit;

    private boolean isItemDeleted;

    public GroceryItem() {
    }

    public GroceryItem(String itemId, String itemName, int itemPrice, int itemAvailableStock, String itemMeasuringUnit, boolean isItemDeleted) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableStock = itemAvailableStock;
        this.itemMeasuringUnit = itemMeasuringUnit;
        this.isItemDeleted = isItemDeleted;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemAvailableStock() {
        return itemAvailableStock;
    }

    public void setItemAvailableStock(int itemAvailableStock) {
        this.itemAvailableStock = itemAvailableStock;
    }

    public String getItemMeasuringUnit() {
        return itemMeasuringUnit;
    }

    public void setItemMeasuringUnit(String itemMeasuringUnit) {
        this.itemMeasuringUnit = itemMeasuringUnit;
    }

    public boolean isItemDeleted() {
        return isItemDeleted;
    }

    public void setItemDeleted(boolean itemDeleted) {
        isItemDeleted = itemDeleted;
    }
}
