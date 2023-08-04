package com.orderservice.orderservice.domain.orderline.api;

import com.orderservice.orderservice.domain.orderline.impl.OrderLineItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    private String id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
