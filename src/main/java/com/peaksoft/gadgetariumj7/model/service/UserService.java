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
public class UserService  {
    private  final UserRepository userRepository;
    private  final UserMapper userMapper;

     public  AuthWithGoogleResponse save(AuthWithGoogleRequest request){
        User user = userMapper.MapToEntity(request);
         if (user.getName().length() < 2 || user.getLastName().length() < 2) {
             throw new RuntimeException("UserName 2 символдон  коп болсун !");
         }
         if (!user.getEmail().contains("@")) {
             throw new RuntimeException("email'де @ символ камтылышы керек");
         }
        userRepository.save(user);
       return userMapper.mapToResponse(user);
    }






}
