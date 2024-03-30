package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="cart_item_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartItems {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cart_entry_id")
    private long cartEntryId;
    private int quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private GroceryItem groceryItem;


}
