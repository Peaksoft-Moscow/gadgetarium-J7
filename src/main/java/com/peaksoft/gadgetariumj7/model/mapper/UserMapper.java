package com.peaksoft.gadgetariumj7.model.mapper;
import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User MapToEntity(AuthWithGoogleRequest request){
        User user = new User();
       user.setName(request.getName());
       user.setEmail(request.getEmail());
       user.setUserPic(request.getUserPic());
       user.setGender(request.getGender());
       user.setLocal(request.getLocal());
       user.setLastVisit(LocalDateTime.now());
        return user;
    }

    public AuthWithGoogleResponse mapToResponse(User user){
        return AuthWithGoogleResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .userPic(user.getUserPic())
                .gender(user.getGender())
                .local(user.getLocal())
            .build();
    }
}
