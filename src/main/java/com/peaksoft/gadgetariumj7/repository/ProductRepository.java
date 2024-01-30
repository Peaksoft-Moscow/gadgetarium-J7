package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    @Query("select * from ")
//    List<Product> getProductsByCategoryByDiscount(@Param("name") String categoryName);

//    @Query("")
//    List<Product> getProductsBySmartPhoneCategories(String findAll);

//    @Query("delete from Product.id")
//    void deleteByUserId(Long user_id);

    @Query("select p from Product p join p.users u where u.id = p.id and p.subCategory.categoryOfSubCategory.electronicType = 'Smartphones'")
    List<Product> getProductsByCategorySmartphone();

}