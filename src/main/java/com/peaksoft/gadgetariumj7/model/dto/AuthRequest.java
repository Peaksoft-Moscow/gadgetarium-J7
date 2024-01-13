package com.peaksoft.gadgetariumj7.model.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {

    @NotBlank(message = "Name should not be empty!")
    @Size(min = 3, max = 20, message = "Name should be between 6 and 20 characters!")
    String name;

    @NotBlank(message = "lastName is mandatory!")
    @Size(min = 6, max = 30, message = "LastName should be between 6 and 30 characters!")
    String lastName;

    @NotBlank(message = "phoneNumber should not be empty!")
    @Size(min = 6, max = 30, message = "phoneNumber must be between 6 and 30 characters!")
    String phoneNumber;

    @Email(message = "email should be valid")
    @Size(min = 5, max = 30, message = "email must be between 5 and 30 characters!")
    String email;

    @NotBlank(message = "password is mandatory!")
    @Pattern(regexp = "^[a-zA-Z0-9a-яА-Я.,;: _?!+=/'\\\\\"*(){}\\[\\]\\-]{8,100}$", message = "incorrect password")
    @Size(min = 6, max = 20, message = "password must be between 6 and 20 characters!")
    String password;
    String confirm_the_password;
    boolean subscribe;
}