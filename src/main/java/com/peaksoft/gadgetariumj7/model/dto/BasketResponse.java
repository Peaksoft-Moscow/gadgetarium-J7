package com.peaksoft.gadgetariumj7.model.dto;

import com.nimbusds.openid.connect.sdk.UserInfoResponse;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import com.peaksoft.gadgetariumj7.model.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BasketResponse {
    private Long id;
    private int quantity;
    private double price;
    private int discount;
    private double totalPrice;
    private ProductResponse productResponse;

}
