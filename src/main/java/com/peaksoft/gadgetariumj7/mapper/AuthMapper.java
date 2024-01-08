package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.dto.AuthRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import com.peaksoft.gadgetariumj7.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public User mapToEntity(AuthRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        if (request.getPassword().equals(request.getConfirm_the_password())) {
            throw new RuntimeException("password not match");
        }
        user.setConfirm_the_password(request.getConfirm_the_password());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(Role.USER);
        return user;
    }

    public AuthResponse mapToUserResponse(User user) {
        return AuthResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}