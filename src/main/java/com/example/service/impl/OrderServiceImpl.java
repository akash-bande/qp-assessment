package com.example.service.impl;

import com.example.constants.ApplicationConstants;
import com.example.model.CartItems;
import com.example.model.Order;
import com.example.repository.CartItemsRepository;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    CartItemsRepository cartItemsRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartItemsRepository cartItemsRepository) {
        this.orderRepository = orderRepository;
        this.cartItemsRepository = cartItemsRepository;
    }

    @Override
    public Order createOrder(Order order) {
        Order savedOrder=orderRepository.save(order);
        return savedOrder;
    }

    @Override
    public Order getOrderByOrderId(long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public void addAllCartItemsToOrder(List<CartItems> cartItems){
        cartItemsRepository.saveAll(cartItems);
    }

    @Override
    public String changeOrderStatusToDispatch(long orderId) {
        Optional<Order> orderInfo = orderRepository.findById(orderId);
        if(!orderInfo.isEmpty()){
            Order searchedOrder = orderInfo.get();
            searchedOrder.setOrderStatus(ApplicationConstants.ORDER_STATUS_DISPATCH);
            orderRepository.save(searchedOrder);
            return "order status updated to DISPATCH for orderID: "+orderId;
        }
        return "order does not found with orderID: "+orderId;
    }

    @Override
    public String changeOrderStatusToDelivered(long orderId) {
        Optional<Order> orderInfo = orderRepository.findById(orderId);
        if(!orderInfo.isEmpty()){
            Order searchedOrder = orderInfo.get();
            searchedOrder.setOrderStatus(ApplicationConstants.ORDER_STATUS_DELIVERED);
            orderRepository.save(searchedOrder);
            return "order status updated to DELIVERED for orderID: "+orderId;
        }
        return "order does not found with orderID: "+orderId;

    }

    @Override
    public List<Order> getOrderByuserId(int userId) {
        List<Order> searedOrders = orderRepository.findByGroceryUserId(userId);
        return searedOrders;
    }

    @Override
    public List<Order> getOrdersByStatus(String orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
    }

    @Override
    public List<Order> getOrdergreaterthanPrice(int amount) {
        return orderRepository.findByTotalOrderValueGreaterThanEqual(amount);
    }


}
