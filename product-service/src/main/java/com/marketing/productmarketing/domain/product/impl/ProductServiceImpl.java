package com.marketing.productmarketing.domain.product.impl;

import com.marketing.productmarketing.domain.product.api.ProductDto;
import com.marketing.productmarketing.domain.product.api.ProductService;
import com.marketing.productmarketing.domain.product.web.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = toEntity(productDto, new Product());
        log.info("Creating product {}", product);
        return toDto(productRepository.save(product));

    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream()
                .map(ProductResponse::fromEntity)
                .collect(Collectors.toList());
    }

    private ProductDto toDto(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
    private Product toEntity(ProductDto productDto, Product product){
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
