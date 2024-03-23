package com.example.model;

import jakarta.persistence.*;
import org.springframework.util.StringUtils;

@Entity
@Table(name="grocery_items")
public class GroceryItem {
    @Id
    @GeneratedValue
    private long itemId;
    private String itemName;
    private int itemPrice;
    private int itemAvailableStock;
    private String itemMeasuringUnit;

    private boolean isItemDeleted;

    public GroceryItem() {
    }

    public GroceryItem(long itemId, String itemName, int itemPrice, int itemAvailableStock, String itemMeasuringUnit, boolean isItemDeleted) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailableStock = itemAvailableStock;
        this.itemMeasuringUnit = itemMeasuringUnit;
        this.isItemDeleted = isItemDeleted;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
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
    public GroceryItem mergeGroceryItem(GroceryItem newGroceryItem){
            newGroceryItem.setItemId(this.getItemId());
            if(StringUtils.isEmpty(newGroceryItem.getItemName())){
                newGroceryItem.setItemName(this.getItemName());
            }
            if(StringUtils.isEmpty(newGroceryItem.getItemPrice())){
                newGroceryItem.setItemPrice(this.getItemPrice());
            }
            if(StringUtils.isEmpty(newGroceryItem.getItemAvailableStock())){
                newGroceryItem.setItemAvailableStock(this.getItemAvailableStock());
            }
            if(StringUtils.isEmpty(newGroceryItem.getItemMeasuringUnit())){
                newGroceryItem.setItemMeasuringUnit(this.getItemMeasuringUnit());
            }
            return newGroceryItem;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemAvailableStock=" + itemAvailableStock +
                ", itemMeasuringUnit='" + itemMeasuringUnit + '\'' +
                ", isItemDeleted=" + isItemDeleted +
                '}';
    }
}
