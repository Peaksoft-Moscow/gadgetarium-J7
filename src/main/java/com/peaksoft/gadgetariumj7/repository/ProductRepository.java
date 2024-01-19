package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.id in :ids")
    List<Product> getProductsByListIds(@Param("ids") Long ids, @Param("category") String category);


//    @Query("SELECT p from Product p where p.id in :ids ")
//    List<Product> getProducts(@Param("ids") List<Integer> ids);

//    @Query("SELECT p FROM Product p JOIN Brand b ON b.id = p.brandOfProduct.id and where p.id = :userId")
//    List<Product> getProductCategory(@Param("userId") Long userId, @Param("category") String category);

//    @Query("SELECT p from Product p where p.id in :ids")
//    List<Product> getProductsByListIds(@Param("ids") List<Integer> ids, @Param("category") String category);


}