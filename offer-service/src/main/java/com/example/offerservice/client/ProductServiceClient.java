package com.example.offerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/products")
    List<String> getProducts();
}
