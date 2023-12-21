package com.peaksoft.gadgetariumj7.model.mapper;

import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class UserMapper {
    public User MapToEntity(AuthWithGoogleRequest request){
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        user.setUserPic(request.getUserPic());
        user.setEmail(request.getEmail());
        user.setLocale(request.getLocal());
        user.setGender(request.getGender());
        return user;
    }

    public AuthWithGoogleResponse mapToResponse(User user){
        return AuthWithGoogleResponse.builder()
                .name(user.getName())
                .userPic(user.getUserPic())
                .email(user.getEmail())
                .gender(user.getGender())
                .local(user.getLocale()).build();
    }
}
