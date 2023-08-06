package com.productmarketing.inventoryservice.domain.inventory.api;

import com.productmarketing.inventoryservice.domain.inventory.web.InventoryResponse;

import java.util.List;

public interface InventoryService {
     List<InventoryResponse> isInStock(List<String> skuCode);
}
