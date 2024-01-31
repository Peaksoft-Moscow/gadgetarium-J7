package com.peaksoft.gadgetariumj7.model.dto;

import com.peaksoft.gadgetariumj7.model.entities.Category;
import com.peaksoft.gadgetariumj7.model.entities.SubCategory;
import com.peaksoft.gadgetariumj7.model.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ProductRequest {
    private String img;
    private String description;
    private String name;
    @CreatedDate
    private LocalDate createDate;
    private Color color;
    private Memory memory;
    private OperationMemory operationMemory;
    private int quantityOfSIMCards;
    private int price;
    private int quantity;
    private String guarantee;
    private SubCategory subCategory;
    private Brand brand;
    OperationSystem operationSystem;
    private String linkToVideo;
    private String linkToPDF;
    private String rating;
    private int discount;
    private String characteristic;
    private String feedback;
    private String watchStrapMaterial;
    private String watchCorpusMaterial;
    private String watchSize;
    private String genre;
    private String wirelessInterface;
    private String formsOfCorpus;
    private Long subCategoryId;
    private Long brandId;
    private ProductStatus productStatus;
}
