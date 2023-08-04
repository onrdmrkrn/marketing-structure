package com.marketing.productmarketing.domain.product.web;

import com.marketing.productmarketing.domain.product.api.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDto toDto(){
        return ProductDto.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
