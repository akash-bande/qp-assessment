package com.example.repository;

import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from order_details where fk_user_id = ?1",nativeQuery = true)
    public List<Order> findByGroceryUserId(int userId);
    public List<Order> findByOrderStatus(String orderStatus);

    public List<Order> findByTotalOrderValueGreaterThanEqual(int amount);

}
