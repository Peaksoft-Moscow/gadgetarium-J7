package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.BasketResponse;
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
@PostMapping("/addToBasket/{id}")
    public BasketResponse addToBasket(@PathVariable("id")Long productId, Principal principal){
        return basketService.addToBasket(productId, principal);
    }



}
