package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.exception.NotFoundExcepption;
import com.peaksoft.gadgetariumj7.model.dto.BasketResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.service.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/basket")
@Slf4j
public class BasketController {
    final BasketService basketService;
    final ProductRepository productRepository;

    @PostMapping("/addToBasket/{id}")
    public BasketResponse addToBasket(@PathVariable("id") Long productId, Principal principal) {
        return basketService.addToBasket(productId, principal);
    }

    @GetMapping("/findAll")
    public List<Product>getProductFromBasket(Principal principal,Long productId){
        Product product = productRepository.findById(productId).
                orElseThrow(()-> new NotFoundExcepption("HGJHGJGKGK"));
        return basketService.getProductsFromBasket(product,principal);
    }


//    @DeleteMapping("/deleteById/{id}")
//    public String deleteById(@PathVariable("id")Long id){
//        basketService.deleteProductFromBasketById(id);
//        return "Successfully deleted ";
//    }

}
