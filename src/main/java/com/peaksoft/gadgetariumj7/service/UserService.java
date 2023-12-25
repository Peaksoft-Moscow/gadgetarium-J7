package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.model.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.peaksoft.gadgetariumj7.mapper.AuthMapper;
import com.peaksoft.gadgetariumj7.model.dto.AuthRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.peaksoft.gadgetariumj7.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    AuthMapper authMapper;
    UserRepository userRepository;

    public AuthResponse save(AuthRequest request) {
        User user = authMapper.mapToEntity(request);
        log.info("User is created");
        userRepository.save(user);
        return authMapper.mapToUserResponse(user);
    }
}