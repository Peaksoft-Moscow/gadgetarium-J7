package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    @Query("SELECT favorites FROM Favorites favorites WHERE favorites.user.id = :id")
    Favorites getFavoritesByUserId(@Param("id") Long id);
}
