package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.BrandRequest;
import com.peaksoft.gadgetariumj7.model.dto.BrandResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductRequest;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Brand;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getProductName())
                .category(product.getCategory())
                .createdDate(product.getCreateDate())
                .price(String.valueOf(product.getPrice()))
                .color(product.getColor())
                .discount(product.getDiscount())
                .electronic(product.getElectronic())
                .description(product.getDescription())
                .characteristic(product.getCharacteristic())
                .currentPrice(String.valueOf(product.getPrice() - product.getDiscount()))
                .quantity(product.getQuantity())
                .quantityOfSIMCards(product.getQuantityOfSIMCards())
                .memory(product.getMemory())
                .RAM(String.valueOf(product.getOperationSystem()))
                .rating(product.getRating())
                .feedback(product.getFeedback())
                .characteristic(product.getCharacteristic())
                .article(product.getArticle())
                .build();
    }

    public Product mapToEntity(ProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getName());
        product.setColor(request.getColor());
        product.setQuantity(String.valueOf(request.getQuantity()));
        product.setCategory(request.getCategory());
        product.setCreateDate(request.getCreateDate());
        product.setPrice((request.getPrice()));
        product.setElectronic((request.getElectronic()));
        product.setQuantityOfSIMCards((request.getQuantityOfSIMCards()));
        product.setRating((request.getRating()));
        product.setGuarantee(request.getGuarantee());
        product.setCatalog(request.getTypeOfElectronic());
        product.setMemory(request.getMemory());
        product.setOperationMemory(request.getRAM());
        product.setDiscount(request.getDiscount());
        product.setDiscount(request.getDiscount());
        product.setDescription(request.getDescription());
        product.setDiscount(request.getDiscount());
        product.setCharacteristic(request.getCharacteristic());
        product.setFeedback(request.getFeedback());
        product.setOperationSystem(request.getOperationSystem());
        return product;
    }

    public Brand mapToEntityBrand(BrandRequest request) {
        Brand brand = new Brand();
        brand.setId(request.getId());
        brand.setName(request.getBrandName());
        brand.setImg(request.getImg());
        return brand;
    }

    public BrandResponse mapToResponseBrand(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .brandName(brand.getName())
                .img(brand.getImg())
                .build();
    }
}
