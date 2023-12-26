package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.LoginResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.enums.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class LoginMapper {
    public LoginResponse mapToResponse(String token,User user) {
        Role role = Role.ADMIN;
        Role role1 = Role.USER;
        List<Role> roles = new ArrayList<>();
       if (role == null){
           roles.add(role);
           user.setRole(role);
       }else if (role != null){
           roles.add(role1);
           user.setRole(role1);
       }
        return LoginResponse.builder()
                .token(token)
                .roleName(roles.toString())
                .build();
    }
}
