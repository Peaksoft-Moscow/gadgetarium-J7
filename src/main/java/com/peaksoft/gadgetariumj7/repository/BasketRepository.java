package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Basket;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("SELECT basket FROM  Basket  basket WHERE  basket.user.id = :id")
    Basket getBasketByUserid(@Param("id") Long id);

    @Query("SELECT product FROM Product product JOIN product.baskets b WHERE b.id=:id")
    List<Product> findProductsInBasket(@Param("id") Long basketId);
}
