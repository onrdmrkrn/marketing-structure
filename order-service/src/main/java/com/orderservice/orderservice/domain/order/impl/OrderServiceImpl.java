package com.orderservice.orderservice.domain.order.impl;

import com.orderservice.orderservice.domain.order.api.OrderDto;
import com.orderservice.orderservice.domain.order.api.OrderService;
import com.orderservice.orderservice.domain.order.web.OrderRequest;
import com.orderservice.orderservice.domain.orderline.api.OrderLineItemsDto;
import com.orderservice.orderservice.domain.orderline.impl.OrderLineItems;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto placeOrder(OrderRequest orderRequest) {
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
        return fromEntity(order,orderLineItemsList);
    }

    private OrderLineItems mapToEntity(OrderLineItemsDto dto) {
        OrderLineItems entity = new OrderLineItems();
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setSkuCode(dto.getSkuCode());
        return entity;
    }

    private OrderDto fromEntity(Order order,List<OrderLineItems> orderLineItemsList) {
        return OrderDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderLineItemsDtoList(orderLineItemsList.stream()
                        .map(this::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    private OrderLineItemsDto mapToDto(OrderLineItems orderLineItems) {
        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
        orderLineItemsDto.setPrice(orderLineItems.getPrice());
        orderLineItemsDto.setQuantity(orderLineItems.getQuantity());
        orderLineItemsDto.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItemsDto;
    }
}
