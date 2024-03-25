package com.example.controller;

import com.example.exception.GroceryItemNotAvailableException;
import com.example.model.GroceryItem;
import com.example.service.GroceryItemService;
import jakarta.validation.Valid;
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
    public GroceryItem getGroceryItem(@PathVariable long itemId) throws GroceryItemNotAvailableException {

        GroceryItem groceryItem = groceryItemService.getGroceryItem(itemId);
        if(groceryItem!=null)
        {
            return groceryItem;
        }
        else{
            throw new GroceryItemNotAvailableException("Grocery item not found with id "+itemId);
        }
    }

    //@GetMapping("{itemName}")
    public GroceryItem getGroceryItemByItemName(@PathVariable String itemName){

        List<GroceryItem> searchedGroceryItems =  groceryItemService.getGroceryItemByItemName(itemName);
        System.out.println(searchedGroceryItems);
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

    @PostMapping("/delete")
    public String deleteGroceryItem(@RequestBody GroceryItem groceryItem) throws GroceryItemNotAvailableException {

        GroceryItem searchedGroceryitem = getGroceryItemByItemName(groceryItem.getItemName());
        if(!Objects.isNull(searchedGroceryitem)){
           return groceryItemService.deleteGroceryItem(searchedGroceryitem.getItemId());
        }
        else {
            throw new GroceryItemNotAvailableException("Grocery Item not found for deletion");
        }
    }

    @PostMapping()
    public String createAndUpadateGroceryItem(@RequestBody @Valid GroceryItem groceryItem){

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
