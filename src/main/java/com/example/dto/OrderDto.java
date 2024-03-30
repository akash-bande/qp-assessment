package com.example.dto;

import com.example.model.CartItems;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {

    private long orderId;
    private String orderStatus;
    private long userId;
    @NotNull
    private List<CartItemDto> cartItems;
}
