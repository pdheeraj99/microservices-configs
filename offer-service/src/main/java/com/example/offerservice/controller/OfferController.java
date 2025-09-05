package com.example.offerservice.controller;

import com.example.offerservice.client.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private final ProductServiceClient productServiceClient;

    @Autowired
    public OfferController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping
    public List<String> getOffers() {
        // Returning a dummy list of offers for now
        return Arrays.asList("Offer 1: 10% off", "Offer 2: Buy one get one free");
    }

    @GetMapping("/with-products")
    public Map<String, Object> getOffersWithProducts() {
        List<String> offers = getOffers();
        List<String> products = productServiceClient.getProducts();

        Map<String, Object> response = new HashMap<>();
        response.put("available_offers", offers);
        response.put("available_products_from_product_service", products);
        return response;
    }
}
