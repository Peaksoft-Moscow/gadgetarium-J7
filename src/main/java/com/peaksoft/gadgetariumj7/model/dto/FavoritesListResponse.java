package com.peaksoft.gadgetariumj7.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FavoritesListResponse {
    private Long id;
    private List<ProductResponse> productResponses;
}
