package com.marketing.productmarketing.domain.product.api;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
public class ProductDto {
    private final String name;
    private final String description;
    private final BigDecimal price;
}
