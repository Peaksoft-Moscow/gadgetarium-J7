package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Basket;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product where p.")
    List<Product> getByCategories(@Param("categoriesId") Long categoriesId);

//    @Query("SELECT basket FROM  Basket  basket WHERE  basket.user.id = :id")
//    getBasketByUserid(@Param("id") Long id);

    @Query("SELECT product FROM Product product JOIN product.baskets b WHERE b.id=:id")
    List<Product> findProductsInBasket(@Param("id") Long basketId);

    @Query(value = "select * from products p join product_comparison pc on pc.product_id = ?", nativeQuery = true)
    List<Product> getProductId(Long id);

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> getSmartphones();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Laptops and tablets'")
    List<Product> getLapTops();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Accessories'")
    List<Product> getHeadPhones();
}