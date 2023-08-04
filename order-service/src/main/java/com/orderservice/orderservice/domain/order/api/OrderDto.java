package com.orderservice.orderservice.domain.order.api;

import com.orderservice.orderservice.domain.orderline.api.OrderLineItemsDto;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Builder
@Data
public class OrderDto {
    private final String id;
    private final String orderNumber;
    private final List<OrderLineItemsDto> orderLineItemsDtoList;
}
