package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.FavoritesResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.Favorites;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavoritesMapper {
    private final ProductMapper productMapper;
    public FavoritesResponse mapToResponse(Favorites favorites, Product product) {
        return FavoritesResponse.builder()
                .id(favorites.getId())
                .quantity(favorites.getQuantity())
                .price(favorites.getPrice())
                .discount(favorites.getDiscount())
                .totalPrice(favorites.getTotalPrice())
                .productResponse(productMapper.mapToResponse(product))
                .build();
    }

//    public Favorites mapToEntity(FavoritesRequest request) {
//        Favorites favorites = new Favorites();
//        favorites.setId(request.getId());
//        return favorites;
//    }
}
