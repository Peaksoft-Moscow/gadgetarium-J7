package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p JOIN p.users u ON u.productComparison WHERE u.id = :id", nativeQuery = true)
    List<Product> getProductComparisonByUserId(@Param("id") Long id);

    @Query("select distinct productName from Product ")
    List<Product> distinctProducts();


    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> getSmartphones();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Laptops and tablets'")
    List<Product> getLapTops();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Accessories'")
    List<Product> getHeadPhones();
}