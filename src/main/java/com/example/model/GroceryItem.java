package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.List;

@Entity
@Table(name="grocery_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GroceryItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;
    @NotNull(message = "Grocery name should not be blank")
    private String itemName;
    @NotNull(message = "Grocery price should not be blank")
    private int itemPrice;
    @NotNull(message = "Grocery stock should not be blank")
    private int itemAvailableStock;
    @JsonIgnore
    private boolean isItemDeleted = false;

    public void setItemDeleted(boolean itemDeleted) {
        isItemDeleted = itemDeleted;
    }
    public GroceryItem mergeGroceryItem(GroceryItem newGroceryItem){
            newGroceryItem.setItemId(this.getItemId());
            if(StringUtils.isEmpty(newGroceryItem.getItemName())){
                newGroceryItem.setItemName(this.getItemName());
            }
            if(StringUtils.isEmpty(String.valueOf(newGroceryItem.getItemPrice()))){
                newGroceryItem.setItemPrice(this.getItemPrice());
            }
            if(StringUtils.isEmpty(String.valueOf(newGroceryItem.getItemAvailableStock()))){
                newGroceryItem.setItemAvailableStock(this.getItemAvailableStock());
            }
            return newGroceryItem;
    }
}
