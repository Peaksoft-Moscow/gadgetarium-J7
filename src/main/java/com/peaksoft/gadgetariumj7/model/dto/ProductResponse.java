package com.peaksoft.gadgetariumj7.model.dto;

import com.peaksoft.gadgetariumj7.model.entities.SubCategory;
import com.peaksoft.gadgetariumj7.model.enums.Color;
import com.peaksoft.gadgetariumj7.model.enums.Memory;
import com.peaksoft.gadgetariumj7.model.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String img;
    private SubCategory subCategory;
    private LocalDate createdDate;
    private String quantity;
    private String price;
    private int discount;
    private String currentPrice;
    private Color color;
    private Memory memory;
    private int quantityOfSIMCards;
    private String description;
    private String characteristic;
    private int article;
    private String RAM;
    private String feedback;
    private boolean PDF;
    private String rating;
    private BrandResponse brand;
    private ProductStatus productStatus;
}
