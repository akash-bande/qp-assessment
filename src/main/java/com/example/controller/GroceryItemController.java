package com.example.controller;

import com.example.model.GroceryItem;
import com.example.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceryitems")
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemService;

//    public GroceryItemController(GroceryItemService groceryItemService) {
//        this.groceryItemService = groceryItemService;
//    }

    @GetMapping("{itemId}")
    public GroceryItem getGroceryItem(String itemId){
        return groceryItemService.getGroceryItem(itemId);
    }

    @GetMapping
    public List<GroceryItem> getAllGroceryItems(){
        return groceryItemService.getAllGroceryItems();
    }

    @PostMapping
    public String createAndUpadateGroceryItem(@RequestBody GroceryItem groceryItem){

        return groceryItemService.createGroceryItem(groceryItem);
//        GroceryItem searchedGroceryitem = getGroceryItem(groceryItem.getItemId());
//        if(Objects.isNull(searchedGroceryitem)){
//           return groceryItemService.createGroceryItem(groceryItem);
//        }
//        else {
//            return groceryItemService.updateGroceryItem(groceryItem);
//        }
    }
}
