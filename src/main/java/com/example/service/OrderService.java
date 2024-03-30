package com.example.service;

import com.example.model.CartItems;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    public Order createOrder(Order order);

    public void addAllCartItemsToOrder(List<CartItems> cartItems);

    public Order getOrderByOrderId(long orderId);

    public String changeOrderStatusToDispatch(long orderId);
    public String changeOrderStatusToDelivered(long orderId);
    public List<Order> getOrderByuserId(int userId);
    public List<Order> getOrdersByStatus(String orderStatus);
    public List<Order> getOrdergreaterthanPrice(int amount);


}
