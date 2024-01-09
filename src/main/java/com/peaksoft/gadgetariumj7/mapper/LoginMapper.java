package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.LoginResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {
    public LoginResponse mapToResponse(String token,User user) {
        return LoginResponse.builder()
                .token(token)
                .roleName(user.getRole())
                .build();
    }
}
