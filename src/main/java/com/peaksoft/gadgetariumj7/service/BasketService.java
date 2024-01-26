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
        myBasket.setPrice(myBasket.getPrice()+product.getPrice());
        myBasket.setDiscount(myBasket.getDiscount());
        myBasket.setTotalPrice(myBasket.getPrice()% myBasket.getDiscount());
        basketRepository.save(myBasket);
        log.info("Create  a new Basket");
        return basketMapper.mapToResponse(myBasket, product);


    }

//    public List<BasketProductResponse> getAllProductsFromTheBasket(Product product){
//        List<BasketProductResponse> basketProductResponses = new ArrayList<>();
//        for(Basket basket : basketRepository.findAll()){
//            basketProductResponses.add(basketMapper.mapToResponse(basket,product));
//        }return basketProductResponses;
//    }

    public  void deleteProductFromBasketById(Long id){
        Basket basket = basketRepository.findById(id).
                orElseThrow(()-> new NotFoundExcepption("Product not found with this Id"));
        basketRepository.deleteById(basket.getId());
        log.info("Successfully deleted");
    }


}
