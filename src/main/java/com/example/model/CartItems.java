package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="cart_item_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartItems {
    @Id
    private String cartEntryId;
    private String orderId;
    private String groceryItemId;
    private int quantity;

    public String getOrderId() {
        return orderId;
    }

}
