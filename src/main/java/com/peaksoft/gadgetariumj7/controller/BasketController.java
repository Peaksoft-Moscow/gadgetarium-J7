package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.BasketProductResponse;
import com.peaksoft.gadgetariumj7.model.dto.BasketResponse;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.service.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    public BasketProductResponse getAllProductsInBasket(Principal principal) {
        return basketService.getProductsFromBasket(principal);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long productId, Principal principal) {
        basketService.deleteProduct(productId, principal);
        return ResponseEntity.ok("Product successfully deleted from basket");
    }

    @PostMapping("/clearBasket")
    public ResponseEntity<String> clearBasket(Principal principal) {
        basketService.clearBasket(principal);
        return ResponseEntity.ok("Your basket has been successfully emptied");
    }
}


