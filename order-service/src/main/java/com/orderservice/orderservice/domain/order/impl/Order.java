package com.orderservice.orderservice.domain.order.impl;
import com.orderservice.orderservice.domain.orderline.impl.OrderLineItems;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
