package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.BasketMapper;
import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.BasketResponse;
import com.peaksoft.gadgetariumj7.model.entities.Basket;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.BasketRepository;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {
    final ProductRepository productRepository;
    final UserRepository userRepository;
    final ProductMapper productMapper;
    final BasketMapper basketMapper;
    final BasketRepository basketRepository;

    public BasketResponse addToBasket(Long productId, Principal principal) {

        User user = userRepository.findByEmail(principal.getName()).
                orElseThrow(() -> new RuntimeException("User not found with this username " + principal.getName()));

        Product product = productRepository.findById(productId).
                orElseThrow(() -> new RuntimeException("Product not found with this Id"));
        if (product.getQuantity() <= 0) {
            throw new RuntimeException("This product is out of stock");
        }
        List<Basket> baskets = basketRepository.getBasketByUserid(user.getId());
        if (!baskets.contains(product)){
            baskets.add(product);
        }
        List<Product> products = new ArrayList<>();
        if (!products.contains(product)) {
            products.add(product);
        }
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setProducts(products);
        basketRepository.save(basket);
        log.info("Create  a new Basket");
        return basketMapper.mapToResponse(basket);


    }

    public List<BasketResponse> myBasket(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with this username " + username));
        List<Basket> myBasket = basketRepository.getBasketByUserid(user.getId());
        return myBasket.stream().map(basket -> basketMapper.mapToResponse(basket)).toList();
    }


}
