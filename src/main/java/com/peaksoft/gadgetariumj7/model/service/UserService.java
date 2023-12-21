package com.peaksoft.gadgetariumj7.model.service;

import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.mapper.UserMapper;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    private  final UserMapper userMapper;

    public AuthWithGoogleResponse auth(AuthWithGoogleRequest request){
        User user = userMapper.MapToEntity(request);
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }


}
