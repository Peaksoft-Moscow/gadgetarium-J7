package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.*;
import com.peaksoft.gadgetariumj7.model.entities.Brand;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getProductName())
                .createdDate(product.getCreateDate())
                .price(String.valueOf(product.getPrice()))
                .color(product.getColor())
                .discount(product.getDiscount())
                .description(product.getDescription())
                .characteristic(product.getCharacteristic())
                .currentPrice(String.valueOf(product.getPrice() - product.getDiscount()))
                .memory(product.getMemory())
                .RAM(String.valueOf(product.getOperationSystem()))
                .rating(product.getRating())
                .feedback(product.getFeedBack())
                .characteristic(product.getCharacteristic())
                .subCategory(product.getSubCategory())
                .brand(mapToResponseBrand(product.getBrandOfProduct()))
                .productStatus(product.getProductStatus())
                .build();
    }
    public Product mapToEntity(ProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getName());
        product.setColor(request.getColor());
        product.setCreateDate(request.getCreateDate());
        product.setPrice((request.getPrice()));
        product.setRating((request.getRating()));
        product.setGuarantee(request.getGuarantee());
        product.setMemory(request.getMemory());
        product.setOperationMemory(request.getOperationMemory());
        product.setDiscount(request.getDiscount());
        product.setDiscount(request.getDiscount());
        product.setDescription(request.getDescription());
        product.setDiscount(request.getDiscount());
        product.setCharacteristic(request.getCharacteristic());
        product.setFeedBack(request.getFeedback());
        product.setOperationSystem(request.getOperationSystem());
        product.setProductStatus(request.getProductStatus());
        return product;
    }

    public Brand mapToEntityBrand(BrandRequest request) {
        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        return brand;
    }

    public BrandResponse mapToResponseBrand(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .brandName(brand.getBrandName())
                .build();
    }
}
