package com.peaksoft.gadgetariumj7.model.dto;
import com.peaksoft.gadgetariumj7.model.entities.BrandEn;
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
    private Long id;
    private String img;
    private Category category;
    private String subCategory;
    private String description;
    private Electronic electronic;
    private String brand;
    private String name;
    @CreatedDate
    private LocalDate createDate;
    private Color color;
    private Memory memory;
    private OperationMemory RAM;
    private int quantityOfSIMCards;
    private int price;
    private int quantity;
    private String guarantee;
    private Electronic typeOfElectronic;
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
}
