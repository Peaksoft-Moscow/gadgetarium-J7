package com.peaksoft.gadgetariumj7.model.dto;

import com.peaksoft.gadgetariumj7.model.enums.Color;
import com.peaksoft.gadgetariumj7.model.enums.Memory;
import com.peaksoft.gadgetariumj7.model.enums.OperationSystem;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComparisonResponse {

    Long id;
    String BrandOfProduct;
    String screen;
    Color color;
    OperationSystem operationSystem;
    Memory memory;
    int wight;
    String simCard;
}
