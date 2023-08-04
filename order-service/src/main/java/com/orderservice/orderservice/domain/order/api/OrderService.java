package com.orderservice.orderservice.domain.order.api;

import com.orderservice.orderservice.domain.order.impl.Order;
import com.orderservice.orderservice.domain.order.web.OrderRequest;

public interface OrderService {

    public OrderDto placeOrder(OrderRequest orderRequest);
}
