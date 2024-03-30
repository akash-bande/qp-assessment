package com.example.repository;

import com.example.model.CartItems;
import com.example.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

    @Query(value = "select * from cart_item_details where fk_order_id = ?1",nativeQuery = true)
    public List<CartItems> findByOrderId(long orderId);

}
