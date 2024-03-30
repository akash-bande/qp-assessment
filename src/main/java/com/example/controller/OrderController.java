package com.example.controller;

import com.example.constants.ApplicationConstants;
import com.example.dto.CartItemDto;
import com.example.dto.OrderDto;
import com.example.model.CartItems;
import com.example.model.Order;
import com.example.service.GroceryItemService;
import com.example.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    GroceryItemService groceryItemService;

    public OrderController(OrderService orderService, GroceryItemService groceryItemService) {
        this.orderService = orderService;
        this.groceryItemService = groceryItemService;
    }

    @PostMapping("/placeorder")
    @PreAuthorize("hasAuthority('GROCERY_USER') or hasAuthority('ADMIN')")
    public ResponseEntity<String> placeOrder(@RequestBody @Valid OrderDto orderdetails){
        Order newOrder = new Order();
        newOrder.setOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);
        newOrder = orderService.createOrder(newOrder);
        Order finalNewOrder = newOrder;
        List<CartItemDto> cartItemsDtoList = orderdetails.getCartItems();
        final long orderId = newOrder.getOrderId();
        cartItemsDtoList.forEach(item -> item.setOrderId(orderId));
        List<CartItems> cartItems = cartItemsDtoList.stream().map(this::convertDtoToEntity).collect(Collectors.toList());
        orderService.addAllCartItemsToOrder(cartItems);
        return new ResponseEntity<>("Order created successfully", HttpStatus.OK);
    }

    public CartItems convertDtoToEntity(CartItemDto cartItemDto){
        CartItems cartItem = new CartItems();
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setGroceryItem(groceryItemService.getGroceryItem(cartItemDto.getGroceryItemId()));
        cartItem.setOrder(orderService.getOrderByOrderId(cartItemDto.getOrderId()));
        return cartItem;
    }


}
