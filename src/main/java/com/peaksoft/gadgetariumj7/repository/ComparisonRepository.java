package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComparisonRepository {

    @Query("select distinct p from User u join u.productComparison p where u.id =:userId and p.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> smartphones(Long userId);

    @Query("select distinct p from User u join u.productComparison p where u.id =:userId and p.subCategory.categoryOfSubCategory.electronicType = 'Laptops and tablets'")
    List<Product> laptops(Long userId);

    @Query("select distinct p from User u join u.productComparison p where u.id =:userId and p.subCategory.categoryOfSubCategory.electronicType = 'Headphones'")
    List<Product> headphones(Long userId);

    @Query("select product from Product product join product.users u where u.id =:id")
    List<Product> getProductComparisonByUserId(@Param("userId") Long userId);

    @Query("select distinct productName from Product")
    List<String> distinctProducts();

}
