package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.exception.IncorrectCodeException;
import com.peaksoft.gadgetariumj7.exception.NotFoundExcepption;
import com.peaksoft.gadgetariumj7.mapper.FavoritesMapper;
import com.peaksoft.gadgetariumj7.model.dto.FavoritesResponse;
import com.peaksoft.gadgetariumj7.model.dto.ProductResponse;
import com.peaksoft.gadgetariumj7.model.entities.*;
import com.peaksoft.gadgetariumj7.repository.FavoritesRepository;
import com.peaksoft.gadgetariumj7.repository.ProductRepository;
import com.peaksoft.gadgetariumj7.repository.SubCategoryRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoriteService {
    private final ProductRepository productRepository;
    private final FavoritesRepository favoritesRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final FavoritesMapper favoritesMapper;
    private final UserRepository userRepository;

    public FavoritesResponse addToFavorites(Long productId, Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).
                orElseThrow(() -> new NotFoundExcepption("User not found"));

        Product product = productRepository.findById(productId).
                orElseThrow(() -> new NotFoundExcepption("Product not found"));

        Favorites favorites = favoritesRepository.getFavoritesByUserId(user.getId());
        List<Product> products = new ArrayList<>();
        products.add(product);
        if (favorites.getProducts().contains(product)){
            throw new IncorrectCodeException("");
        }
        favorites.setProducts(products);
        favorites.setQuantity(favorites.getQuantity());
        favorites.setPrice(favorites.getPrice());
        favorites.setDiscount(favorites.getDiscount());
        favorites.setTotalPrice(favorites.getTotalPrice());
        favoritesRepository.save(favorites);
        log.info("added favorites");
        return favoritesMapper.mapToResponse(favorites, product);
    }

    public void deleteFavoritesById(Long id) {
        Favorites favorites = favoritesRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepption("There is no favorites with this id! <<" + id + ">>")
        );
        favoritesRepository.deleteById(favorites.getId());
        log.info("Deleted");
    }
}
