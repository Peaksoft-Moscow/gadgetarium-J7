package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.FavoritesResponse;
import com.peaksoft.gadgetariumj7.model.entities.Favorites;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavoritesMapper {
    private final ProductMapper productMapper;
    public FavoritesResponse mapToResponse(Favorites favorites, Product product) {
        return FavoritesResponse.builder()
                .id(favorites.getId())
                .productResponse(productMapper.mapToResponse(product))
                .build();
    }
}
