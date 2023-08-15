package com.orderservice.orderservice.domain.order.web;

import com.orderservice.orderservice.domain.order.api.OrderDto;
import com.orderservice.orderservice.domain.order.impl.OrderServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderServiceImpl orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "placeOrderFallback")
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest) + " order placed successfully";
    }

    public String placeOrderFallback(OrderRequest orderRequest, Exception e){
        return "Order service is down. Please try again later " + orderRequest + e.getMessage();
    }
}
