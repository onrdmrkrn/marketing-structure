package com.marketing.productmarketing.domain.product.web;

import com.marketing.productmarketing.domain.product.api.ProductDto;
import com.marketing.productmarketing.domain.product.api.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ProductDto createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest.toDto());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
