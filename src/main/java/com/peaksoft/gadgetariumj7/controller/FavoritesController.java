package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.FavoritesListResponse;
import com.peaksoft.gadgetariumj7.model.dto.FavoritesResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.service.FavoriteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

    @GetMapping("/getAllFavorites")
    public FavoritesListResponse getAllFavorites(Principal principal) {
        return favoriteService.getAllFavorites(principal);
    }

    @DeleteMapping("/deleteFromFavorites/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long productId, Principal principal){
        favoriteService.deleteFromFavorites(productId, principal);
        return ResponseEntity.ok("Product successfully deleted from favorites");
    }

    @PostMapping("/deleteAllFavorites")
    public ResponseEntity<String> deleteAll(Principal principal) {
        favoriteService.deleteAllFavorites(principal);
        return ResponseEntity.ok("Your favorites list has been successfully emptied");
    }
}
