package com.productmarketing.inventoryservice.domain.inventory.web;

import com.productmarketing.inventoryservice.domain.inventory.api.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable ("sku-code") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}