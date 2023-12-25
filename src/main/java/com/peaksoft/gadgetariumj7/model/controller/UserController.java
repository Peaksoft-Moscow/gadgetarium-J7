package com.peaksoft.gadgetariumj7.model.controller;

import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthWithGoogleResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.mapper.UserMapper;
import com.peaksoft.gadgetariumj7.model.service.UserService;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //    @GetMapping("/signUp")
//    public Principal user(Principal principal){
//        System.out.println("username: " + principal.getName());
//        return principal;
//    }
    @GetMapping("/signUp")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }






}
