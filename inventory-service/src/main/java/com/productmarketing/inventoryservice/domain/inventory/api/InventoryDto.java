package com.productmarketing.inventoryservice.domain.inventory.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class InventoryDto {
    private final String skuCode;
    private final boolean isInStock;
}