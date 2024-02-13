package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Brand;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.enums.Color;
import com.peaksoft.gadgetariumj7.model.enums.Memory;
import com.peaksoft.gadgetariumj7.model.enums.OperationMemory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("""
            SELECT product FROM Product  product WHERE
            product.brandOfProduct.brandName IN :brand OR
            product.price IN :price AND  product.price BETWEEN  500 AND 205000 OR
            CAST(product.color AS string)  IN :color OR
            CAST(product.memory AS string) IN :memory OR
            CAST(product.operationMemory AS string) IN :operationMemory
            """)
    List<Product> productFilter(
            @Param("brand") List<String> brands,
            @Param("price") List<Integer> prices,
            @Param("color") List<String> colors,
            @Param("memory") List<String> memories,
            @Param("operationMemory") List<String> operationMemory);
}


