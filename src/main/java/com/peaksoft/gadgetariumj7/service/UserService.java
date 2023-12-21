package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.model.entityes.Role;
import com.peaksoft.gadgetariumj7.model.entityes.User;
import com.peaksoft.gadgetariumj7.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import com.peaksoft.gadgetariumj7.mapper.AuthMapper;
import com.peaksoft.gadgetariumj7.model.dto.AuthRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import org.springframework.stereotype.Service;
import com.peaksoft.gadgetariumj7.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {

    final AuthMapper authMapper;
    final UserRepository userRepository;
    final RoleRepository roleRepository;

    public AuthResponse save(AuthRequest request) {
        User user = authMapper.mapToEntity(request);
        if (user.getName().length() < 6 || user.getLastName().length() < 6) {
            throw new RuntimeException("The name must contain more than 6 characters!");
        }
        if (!user.getEmail().contains("@")) {
            throw new RuntimeException("email must also contain the @ symbol!");
        }
        if (user.getPassword().length() < 6) {
            throw new RuntimeException("The password must contain more than 6 characters!");
        }
//        user.setPassword(request.getPassword());
        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findByName("ADMIN");
        if (userRepository.findAll().isEmpty()) {
            if (role == null) {
                role = new Role("ADMIN");
            }
            roles.add(role);
        } else {
            Role role1 = roleRepository.findByName("USER");
            if (role1 == null) {
                role1 = new Role("USER");
            }
            roles.add(role1);
        }
        user.setRoles(roles);
        userRepository.save(user);
        return authMapper.mapToUserResponse(user);
    }
}