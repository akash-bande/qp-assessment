package com.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroceryItemDto {

    private long itemId;
    private String itemName;
    private int itemPrice;
    private int itemAvailableStock;
    private String itemMeasuringUnit;

}
