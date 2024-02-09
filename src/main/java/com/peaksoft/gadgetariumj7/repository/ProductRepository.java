package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "")
    List<Product> getMyProductId();

    @Query(value = "select * from products p join product_comparison pc on pc.product_id = ?", nativeQuery = true)
    List<Product> getProductId(Long id);

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> getSmartphones();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Laptops and tablets'")
    List<Product> getLapTops();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Accessories'")
    List<Product> getHeadPhones();
}