package com.peaksoft.gadgetariumj7.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.peaksoft.gadgetariumj7.model.dto.AuthRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.peaksoft.gadgetariumj7.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {

    final UserService userService;
    @PostMapping("/sign-up")
    public AuthResponse signUp(@RequestBody @Valid AuthRequest request,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return userService.save(request);
        return userService.save(request);
    }
}