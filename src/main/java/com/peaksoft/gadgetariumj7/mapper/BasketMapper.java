package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.*;
import com.peaksoft.gadgetariumj7.model.entities.Basket;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BasketMapper {
    public final ProductRepository productRepository;
    public final UserRepository userRepository;
    public final ProductMapper productMapper;


    public BasketResponse mapToResponse(Basket basket, Product product) {
        return BasketResponse.builder()
                .id(basket.getId())
                .quantity(basket.getQuantity())
                .price(basket.getPrice())
                .discount(basket.getDiscount())
                .totalPrice(basket.getTotalPrice())
                .productResponse(productMapper.mapToResponse(product))
                .build();
    }

    public BasketProductResponse mapToResponse(Product product) {
        BasketProductResponse response = new BasketProductResponse();
        response.setId(product.getId());
        response.setDiscount(product.getDiscount());
        response.setPrice(product.getPrice());
        return response;
    }
}
