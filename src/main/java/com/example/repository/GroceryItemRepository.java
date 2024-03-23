package com.example.repository;

import com.example.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    public List<GroceryItem> findByItemNameEquals(String itemName);
}
