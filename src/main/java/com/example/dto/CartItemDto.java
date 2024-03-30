package com.example.dto;

import com.example.model.CartItems;
import com.example.service.GroceryItemService;
import com.example.service.OrderService;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class CartItemDto {

    @Autowired
    private GroceryItemService groceryItemService;

    @Autowired
    private OrderService orderService;

    private long cartEntryId;
    @NotNull
    private int quantity;
    @NotNull
    private long groceryItemId;
    private long orderId;

    public CartItemDto(long cartEntryId, int quantity, long groceryItemId, long orderId) {
        this.cartEntryId = cartEntryId;
        this.quantity = quantity;
        this.groceryItemId = groceryItemId;
        this.orderId = orderId;
    }
}
