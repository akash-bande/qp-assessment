package com.example.service.impl;

import com.example.model.GroceryItem;
import com.example.repository.GroceryItemRepository;
import com.example.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    GroceryItemRepository groceryItemRepository;

    public GroceryItemServiceImpl(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getGroceryItem(String itemId) {
        return groceryItemRepository.findById(itemId).orElse(null);
    }

    @Override
    public String updateGroceryItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
        return "Grocery item updated successfully.";
    }

    @Override
    public String createGroceryItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
        return "Grocery item added successfully.";
    }

    @Override
    public String deleteGroceryItem(String itemId) {
        GroceryItem groceryItem = getGroceryItem(itemId);
        groceryItem.setItemDeleted(true);
        groceryItemRepository.save(groceryItem);
        return "Grocery item deleted successfully.";
    }
}
