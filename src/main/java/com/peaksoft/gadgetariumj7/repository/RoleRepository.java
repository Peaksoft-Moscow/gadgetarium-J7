package com.peaksoft.gadgetariumj7.repository;

import com.peaksoft.gadgetariumj7.model.entityes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select role from Role role where role.name=:roleName")
    Role findByName(@Param("roleName")String roleName);
}
