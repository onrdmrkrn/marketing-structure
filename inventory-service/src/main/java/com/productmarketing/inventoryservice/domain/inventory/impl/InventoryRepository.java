package com.productmarketing.inventoryservice.domain.inventory.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository  extends JpaRepository<Inventory, String> {
    public Optional<Inventory> findBySkuCode(String skuCode);
}
