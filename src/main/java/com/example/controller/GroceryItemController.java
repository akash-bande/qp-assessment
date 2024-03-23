package com.example.controller;

import com.example.model.GroceryItem;
import com.example.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/groceryitems")
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemService;

    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @GetMapping("{itemId}")
    public GroceryItem getGroceryItem(@PathVariable long itemId){
        return groceryItemService.getGroceryItem(itemId);
    }

    //@GetMapping("{itemName}")
    public GroceryItem getGroceryItemByItemName(@PathVariable String itemName){

        List<GroceryItem> searchedGroceryItems =  groceryItemService.getGroceryItemByItemName(itemName);
        if(!searchedGroceryItems.isEmpty())
            return searchedGroceryItems.get(0);
        else{
            return null;
        }
    }

    @GetMapping
    public List<GroceryItem> getAllGroceryItems(){
        return groceryItemService.getAllGroceryItems();
    }

    @PostMapping
    public String createAndUpadateGroceryItem(@RequestBody GroceryItem groceryItem){

        GroceryItem searchedGroceryitem = getGroceryItemByItemName(groceryItem.getItemName());
        if(Objects.isNull(searchedGroceryitem)){
           return groceryItemService.createGroceryItem(groceryItem);
        }
        else {
            GroceryItem updatedGroceryitem = searchedGroceryitem.mergeGroceryItem(groceryItem);
            return groceryItemService.updateGroceryItem(updatedGroceryitem);
        }
    }
}
