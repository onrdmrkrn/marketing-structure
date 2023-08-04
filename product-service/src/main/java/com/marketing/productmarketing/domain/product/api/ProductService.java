package com.marketing.productmarketing.domain.product.api;

import com.marketing.productmarketing.domain.product.web.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductResponse> getAllProducts();
}
