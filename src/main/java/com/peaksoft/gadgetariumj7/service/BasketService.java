package com.peaksoft.gadgetariumj7.service;

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
                orElseThrow(() -> new NotFoundExcepption("Product not found with this " + productId));

        Basket myBasket = basketRepository.getBasketByUserid(user.getId());
        List<Product> products = myBasket.getProducts();
        products.add(product);
        myBasket.setProducts(products);
        myBasket.setQuantity(myBasket.getQuantity() + 1);
        myBasket.setPrice(myBasket.getPrice() + product.getPrice());
        myBasket.setDiscount(myBasket.getDiscount() + (product.getPrice() / 100 * product.getDiscount()));
        myBasket.setTotalPrice(myBasket.getPrice() - myBasket.getDiscount());
        List<Basket> baskets = new ArrayList<>();
        baskets.add(myBasket);
        myBasket.setProducts(products);
        product.setBaskets(baskets);
        productRepository.save(product);
        basketRepository.save(myBasket);
        log.info("Create a new Basket");
        return basketMapper.mapToResponse(myBasket, product);
    }


    public BasketProductResponse getProductsFromBasket(Principal principal) {

        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new NotFoundExcepption("User not found with " + principal));

        Basket myBasket = basketRepository.getBasketByUserid(user.getId());
        System.out.println(myBasket.getId());
        List<Product> products = basketRepository.findProductsInBasket(myBasket.getId());
        System.out.println("Products");
        System.out.println(products.isEmpty());
        System.out.println(products.size());
        BasketProductResponse productResponse = new BasketProductResponse();
        productResponse.setId(myBasket.getId());
        productResponse.setDiscount(myBasket.getDiscount());
        productResponse.setPrice(myBasket.getPrice());
        productResponse.setQuantity(myBasket.getQuantity());
        productResponse.setTotalPrice(myBasket.getTotalPrice());
        productResponse.setProductResponses(products.stream().map(productMapper::mapToResponse).toList());
        return productResponse;
    }

    public void deleteProduct(Long productId, Principal principal) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundExcepption("Product not found with this " + productId));

        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new NotFoundExcepption("User not found with this username " + principal));

        Basket myBasket = user.getBasket();
        if (myBasket != null) {
            myBasket.setQuantity(myBasket.getQuantity() - 1);
            myBasket.setPrice(myBasket.getPrice() - product.getPrice());
            myBasket.setDiscount(myBasket.getDiscount() - (product.getPrice() / 100 * product.getDiscount()));
            myBasket.setTotalPrice(myBasket.getPrice() - myBasket.getDiscount());
            List<Product> products = myBasket.getProducts();
            products.remove(product);
            myBasket.setProducts(products);
            productRepository.save(product);
            basketRepository.save(myBasket);
        }
    }

    public void clearBasket(Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new NotFoundExcepption("User not found with this username " + principal));

        Basket myBasket = user.getBasket();
        if (myBasket != null) {
            myBasket.getProducts().clear();
            myBasket.setPrice(0.0);
            myBasket.setQuantity(0);
            myBasket.setDiscount(0);
            myBasket.setTotalPrice(0.0);
            basketRepository.save(myBasket);
        } else {
            throw new RuntimeException("Your basket is Empty");
        }
    }
}
