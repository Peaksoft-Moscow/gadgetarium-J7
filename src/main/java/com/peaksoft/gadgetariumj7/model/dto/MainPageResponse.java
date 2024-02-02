package com.peaksoft.gadgetariumj7.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainPageResponse {
    private List<ProductResponse> newDevice;
    private List<ProductResponse> sale;
    private List<ProductResponse> recommend;
}
