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

    @Query("delete from Product ")
    List<Product> deleteByProduct(@Param("id") Long id);

//    @Query(value = "SELECT product_name," +
//            "       screen," +
//            "       color," +
//            "       operation_system," +
//            "       memory," +
//            "       weight," +
//            "       sim_card" +
//            "FROM products inner join categories on product_name = categories.electronic_type", nativeQuery = true)
//    List<Product> getProductCategory(@Param("userId") Long userId, @Param("category") String category);


//    @Query("")
//    List<Product> getByCategories(@Param("categoriesId") Long categoriesId);
//
//    @Query(value = "select users_id from product_comparison users_id where product_id = ?2", nativeQuery = true)
//    List<Product> getMyProductId(@Param("productId") Long productId);
//
//    @Query("select p from Product p join p.users u on u.productComparison where  u.id=:id")
//    List<Product> getProductComparisonByUserId(@Param("id") Long id);


    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> getSmartphones();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Laptops and tablets'")
    List<Product> getLapTops();

    @Query("select product from Product product where product.subCategory.categoryOfSubCategory.electronicType = 'Accessories'")
    List<Product> getHeadPhones();
}