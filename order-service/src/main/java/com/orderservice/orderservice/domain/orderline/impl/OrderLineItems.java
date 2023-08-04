package com.orderservice.orderservice.domain.orderline.impl;


import com.orderservice.orderservice.domain.order.impl.Order;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_line_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderLineItemId;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
