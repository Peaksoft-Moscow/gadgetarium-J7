package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    @Query("SELECT basket FROM  Basket  basket WHERE  basket.user.id = :id")
    Basket getBasketByUserid(@Param("id")Long id);
}
