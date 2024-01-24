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
   public  final ProductRepository productRepository;
   public final UserRepository userRepository;



    public BasketResponse mapToResponse(Basket basket){
        return BasketResponse.builder()
                .id(basket.getId())
                .quantity(basket.getQuantity())
                .user(basket.getUser())
                .build();
    }

//    public Basket mapToEntity(BasketRequest request){
//        Basket basket = new Basket();
//        return basket;
//    }

}
