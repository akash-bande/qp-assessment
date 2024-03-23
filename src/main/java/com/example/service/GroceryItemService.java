package com.example.service;

import com.example.model.GroceryItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroceryItemService {

    public List<GroceryItem> getAllGroceryItems();
    public GroceryItem getGroceryItem(long itemId);
    public List<GroceryItem> getGroceryItemByItemName(String itemName);
    public String updateGroceryItem(GroceryItem groceryItem);
    public String createGroceryItem(GroceryItem groceryItem);
    public String deleteGroceryItem(long itemId);
}
