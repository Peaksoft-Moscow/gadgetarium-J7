package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT  product FROM Product  product WHERE product.productStatus = 'SALES'")
    List<Product> findByStatusSale();
    @Query("SELECT product FROM Product product WHERE product.productStatus = 'NEW_DEVICES'")
    List<Product> findByStatusNewDevice();
    @Query("SELECT product FROM Product product WHERE product.productStatus = 'RECOMMENDATIONS'")
    List<Product> findByStatusRecommend();
    @Query("SELECT product FROM Product product WHERE product.productStatus = 'BY_INCREASING_THE_PRICE'")
    List<Product> findByStatusIncreasedPrice();
    @Query("SELECT product FROM Product product WHERE product.productStatus = 'BY_REDUCING_THE_PRICE'")
    List<Product> findByStatusReducePrice();
}
