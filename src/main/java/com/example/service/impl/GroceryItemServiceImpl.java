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
        loadGroceryItems();
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public GroceryItem getGroceryItem(long itemId) {
        return groceryItemRepository.findById(itemId).orElse(null);
    }

    @Override
    public List<GroceryItem> getGroceryItemByItemName(String itemName) {
        return groceryItemRepository.findByItemNameEquals(itemName);
    }

    @Override
    public String updateGroceryItem(GroceryItem groceryItem) {
        System.out.println(groceryItem.toString());
        groceryItemRepository.save(groceryItem);
        return "Grocery item updated successfully.";
    }

    @Override
    public String createGroceryItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
        return "Grocery item added successfully.";
    }

    @Override
    public String deleteGroceryItem(long itemId) {
        GroceryItem groceryItem = getGroceryItem(itemId);
        groceryItem.setItemDeleted(true);
        groceryItemRepository.save(groceryItem);
        return "Grocery item deleted successfully.";
    }

    private void loadGroceryItems(){
        GroceryItem groceryItem1 = new GroceryItem(1,"Potato",25,350,"KG",false);
        GroceryItem groceryItem2 = new GroceryItem(2,"Tomato",30,200,"KG",false);
        GroceryItem groceryItem3 = new GroceryItem(3,"Onion",20,600,"KG",false);
        GroceryItem groceryItem4 = new GroceryItem(4,"Sugar",40,100,"KG",false);
        GroceryItem groceryItem5 = new GroceryItem(5,"Rice",60,50,"KG",false);
        groceryItemRepository.save(groceryItem1);
        groceryItemRepository.save(groceryItem2);
        groceryItemRepository.save(groceryItem3);
        groceryItemRepository.save(groceryItem4);
        groceryItemRepository.save(groceryItem5);
    }
}
