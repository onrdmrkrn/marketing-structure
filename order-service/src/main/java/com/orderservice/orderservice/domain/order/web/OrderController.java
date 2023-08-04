package com.orderservice.orderservice.domain.order.web;

import com.orderservice.orderservice.domain.order.api.OrderDto;
import com.orderservice.orderservice.domain.order.impl.OrderServiceImpl;
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
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest) + " order placed successfully";
    }
}
