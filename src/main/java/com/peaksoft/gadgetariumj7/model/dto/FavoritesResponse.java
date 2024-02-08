package com.peaksoft.gadgetariumj7.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoritesResponse {
    Long id;
    ProductResponse productResponse;
}
