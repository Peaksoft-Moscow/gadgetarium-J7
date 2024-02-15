package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.exception.IncorrectCodeException;
import com.peaksoft.gadgetariumj7.exception.NotFoundExcepption;
import com.peaksoft.gadgetariumj7.model.entities.Basket;
import com.peaksoft.gadgetariumj7.repository.BasketRepository;
import com.peaksoft.gadgetariumj7.security.jwt.JwtUtil;
import com.peaksoft.gadgetariumj7.mapper.AuthMapper;
import com.peaksoft.gadgetariumj7.mapper.LoginMapper;
import com.peaksoft.gadgetariumj7.model.dto.AuthRequest;
import com.peaksoft.gadgetariumj7.model.dto.AuthResponse;
import com.peaksoft.gadgetariumj7.model.dto.LoginRequest;
import com.peaksoft.gadgetariumj7.model.dto.LoginResponse;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.model.enums.Role;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {
    UserRepository userRepository;
    AuthMapper authMapper;
    AuthenticationManager manager;
    JwtUtil jwtUtil;
    LoginMapper loginMapper;
    PasswordEncoder passwordEncoder;
    JavaMailSender javaMailSender;
    BasketRepository basketRepository;

    public AuthResponse save(AuthRequest request) {
        User user = authMapper.mapToEntity(request);
        user.setCreateDate(LocalDate.now());
        log.info("User is created");
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Basket basket = new Basket();
        user.setBasket(basket);
        basketRepository.save(basket);
        basket.setUser(user);
        userRepository.save(user);
        return authMapper.mapToUserResponse(user);
    }

    public Map<String, Object> saveWithGoogle(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        OAuth2AuthenticatedPrincipal principal = oAuth2AuthenticationToken.getPrincipal();
        if (oAuth2AuthenticationToken == null) {
            throw new NotFoundExcepption("The token must not be null");
        }
        Map<String, Object> attributes = principal.getAttributes();
        User user = new User();
        user.setName((String) attributes.get("given_name"));
        user.setLastName((String) attributes.get("family_name"));
        user.setEmail((String) attributes.get("email"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        attributes.get("given_name");
        user.setCreateDate(LocalDate.now());
        user.setRole(Role.USER);
        userRepository.save(user);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("name", user.getName());
        response.put("lastName", user.getLastName());
        response.put("email", user.getEmail());
        response.put("creatDate", user.getCreateDate());
        return response;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundExcepption("User with: " + request.getEmail() + " not found !"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IncorrectCodeException("The password is incorrect !");
        }
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String jwt = jwtUtil.generateToken(user);
        return loginMapper.mapToResponse(jwt, user);
    }

    public void sendSetPasswordEmail(String email) throws MessagingException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundExcepption("User with: " + email + " not found !"));
        String strCode = String.valueOf(user.getResetCode());
        userRepository.save(user);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Set Password");
        mimeMessageHelper.setText("Your reset code: " + strCode);
        javaMailSender.send(mimeMessage);
    }

    public String forgotPassword(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundExcepption("User with: " + email + " not found !"));
        Random random = new Random();
        Long resetCod = random.nextLong(10000000);
        user.setResetCode(String.valueOf(resetCod));
        userRepository.save(user);
        try {
            sendSetPasswordEmail(email);
        } catch (MessagingException e) {
            throw new NotFoundExcepption("User with: " + email + " not found !");
        }
        return "Please check your email to set new password to your account";
    }

    public String setPassword(String email, String resetCode, String newPassword, String confirmPassword) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User with: " + email + " not found !"));
        if (user.getResetCode().equals(resetCode)) {
            if (newPassword.equals(confirmPassword)) {
                user.setPassword(passwordEncoder.encode(newPassword));
            } else {
                throw new IncorrectCodeException("The password does not match !");
            }
        } else {
            throw new IncorrectCodeException("The code does not match");
        }
        userRepository.save(user);
        return "New password set successfully login with this password";
    }
}

