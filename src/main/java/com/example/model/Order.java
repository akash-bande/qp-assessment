package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
@Entity
@Table(name="order_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    private String orderId;
    private String userId;
    private String orderStatus;
    private ArrayList<CartItems> cartItems;
}
