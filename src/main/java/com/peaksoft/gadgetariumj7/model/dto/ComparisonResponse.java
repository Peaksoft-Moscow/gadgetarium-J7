package com.peaksoft.gadgetariumj7.model.dto;

import com.peaksoft.gadgetariumj7.model.enums.Color;
import com.peaksoft.gadgetariumj7.model.enums.Memory;
import com.peaksoft.gadgetariumj7.model.enums.OperationSystem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ComparisonResponse {

    Long id;
    String BrandOfProduct;
    String screen;
    Color color;
    OperationSystem operationSystem;
    Memory memory;
    int wight;
    int simCard;
}
