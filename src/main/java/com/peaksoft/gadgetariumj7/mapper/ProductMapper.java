package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.BrandEn;
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
        return product;
    }

    public BrandEn mapToEntityBrand(BrandRequest request) {
        BrandEn brand = new BrandEn();
        brand.setId(request.getId());
        brand.setName(request.getBrandName());
        brand.setImg(request.getImg());
        return brand;
    }

    public BrandResponse mapToResponseBrand(BrandEn brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .brandName(brand.getName())
                .img(brand.getImg())
                .build();
    }
}
