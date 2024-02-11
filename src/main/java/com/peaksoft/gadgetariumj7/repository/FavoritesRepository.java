package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Favorites;
import com.peaksoft.gadgetariumj7.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query("SELECT favorites FROM Favorites favorites WHERE favorites.user.id = :id")
    Favorites getFavoritesByUserId(@Param("id") Long id);

    @Query("SELECT product FROM Product product JOIN product.favorites f WHERE f.id=:id")
    List<Product> findProductsInFavorites(@Param("id") Long favoritesId);
}
