package com.example.model;

import com.example.controller.GroceryItemController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private long orderId;
    private String orderStatus;
    private int totalOrderValue;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<CartItems> cartItems;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
