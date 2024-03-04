package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComparisonRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> Smartphones(@Param("userId") Long userId);

    @Query("select p from Product p where p.subCategory.categoryOfSubCategory.electronicType = 'Laptops and'")
    List<Product> Laptops(@Param("userId") Long userId);

    @Query("select p from Product p where p.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> headPhones(@Param("userId") Long userId);

    @Query("select product from Product product join product.users u where u.id =:userId")
    List<Product> getProductComparisonByUserId(@Param("userId") Long userId);

    @Query("select distinct productName from Product")
    List<String> distinctProducts();

}
