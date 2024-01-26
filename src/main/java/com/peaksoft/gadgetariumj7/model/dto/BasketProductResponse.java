package com.peaksoft.gadgetariumj7.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BasketProductResponse {
    private  Long id;
    private String name;
    private int price;
    private int discount;
}
