package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.exception.IncorrectCodeException;
import com.peaksoft.gadgetariumj7.exception.NotFoundExcepption;
import com.peaksoft.gadgetariumj7.mapper.BasketMapper;
import com.peaksoft.gadgetariumj7.mapper.ProductMapper;
import com.peaksoft.gadgetariumj7.model.dto.BasketProductResponse;
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
                orElseThrow(() -> new NotFoundExcepption("User not found with this username " + principal.getName()));

        Product product = productRepository.findById(productId).
                orElseThrow(() -> new NotFoundExcepption("Product not found with this Id"));

        Basket myBasket = basketRepository.getBasketByUserid(user.getId());
        List<Product> products = new ArrayList<>();
        products.add(product);
        if (myBasket.getProducts().contains(product)) {
            throw new IncorrectCodeException("");
        }
        myBasket.setProducts(products);
        myBasket.setQuantity(myBasket.getQuantity() + 1);
        myBasket.setPrice(myBasket.getPrice() + product.getPrice());
        myBasket.setDiscount(product.getDiscount() + product.getDiscount());
        myBasket.setTotalPrice(myBasket.getTotalPrice() % product.getDiscount());
        basketRepository.save(myBasket);
        log.info("Create a new Basket");
        return basketMapper.mapToResponse(myBasket,product);
    }


    public BasketProductResponse getProductsFromBasket(Principal principal) {

        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new NotFoundExcepption("User not found with " + principal.getName()));
        Basket basket = basketRepository.getBasketByUserid(user.getId());
        System.out.println(basket.getId());
        List<Product> products = basketRepository.findProductsInBasket(basket.getId());
        System.out.println("Products");
        System.out.println(products.isEmpty());
        System.out.println(products.size());
        BasketProductResponse productResponse = new BasketProductResponse();
        productResponse.setId(basket.getId());
        productResponse.setDiscount(basket.getDiscount());
        productResponse.setPrice(basket.getPrice());
        productResponse.setQuantity(basket.getQuantity());
        productResponse.setTotalPrice(basket.getTotalPrice());
        productResponse.setProductResponses(basket.getProducts().stream().map()));

    }
}
