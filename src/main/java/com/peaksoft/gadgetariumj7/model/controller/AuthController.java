package com.peaksoft.gadgetariumj7.model.controller;

import com.peaksoft.gadgetariumj7.model.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {

        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }

    @GetMapping("/with-google")
    public Map<String, Object> addUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) throws IllegalAccessException {
        return authService.saveWithGoogle(oAuth2AuthenticationToken);
    }
}
