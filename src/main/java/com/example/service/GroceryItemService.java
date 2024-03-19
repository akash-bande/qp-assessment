package com.example.service;

import com.example.model.GroceryItem;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroceryItemService {

    public List<GroceryItem> getAllGroceryItems();
    public GroceryItem getGroceryItem(String itemId);
    public String updateGroceryItem(GroceryItem groceryItem);
    public String createGroceryItem(GroceryItem groceryItem);
    public String deleteGroceryItem(String itemId);
}
