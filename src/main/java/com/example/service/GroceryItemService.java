package com.example.service;

import com.example.model.GroceryItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroceryItemService {

    public List<GroceryItem> getAllGroceryItems();
    public GroceryItem getGroceryItem(String itemId);
    public String updateGroceryItem(GroceryItem groceryItem);
    public String createGroceryItem(GroceryItem groceryItem);
    public String deleteGroceryItem(String itemId);
}
