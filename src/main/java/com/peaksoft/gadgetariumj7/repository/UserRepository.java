package com.peaksoft.gadgetariumj7.repository;
import com.peaksoft.gadgetariumj7.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
