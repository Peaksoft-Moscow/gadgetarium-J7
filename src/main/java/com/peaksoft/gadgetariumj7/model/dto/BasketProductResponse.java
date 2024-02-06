package com.peaksoft.gadgetariumj7.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketProductResponse {
    private Long id;
    private double price;
    private int discount;
    private double totalPrice;
    private int quantity;
    private List<ProductResponse> productResponses;


}
