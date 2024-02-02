package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.FavoritesResponse;
import com.peaksoft.gadgetariumj7.service.FavoriteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FavoritesController {
    private final FavoriteService favoriteService;
    @PostMapping("/addToFavorites/{id}")
    public FavoritesResponse addToFavorites(@PathVariable("id") Long productId, Principal principal){
        return favoriteService.addToFavorites(productId, principal);
    }
//    @DeleteMapping("/deleteFromFavorites/{id}")
//    public String deleteFavoritesById(@PathVariable("id") Long productId, Principal principal){
//        favoriteService.deleteFromFavorites(productId, principal);
//        return "deleted";
//    }
}
