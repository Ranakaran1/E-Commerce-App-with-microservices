package com.karan.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{

    boolean existBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity); 
}
