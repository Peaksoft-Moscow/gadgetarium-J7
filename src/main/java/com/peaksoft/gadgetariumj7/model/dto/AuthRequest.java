package com.peaksoft.gadgetariumj7.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {

    @Valid

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 6, max = 20, message = "Name should be between 6 and 20 characters!")
    String name;
    @NotEmpty(message = "lastName is mandatory!")
    @Size(min = 6, max = 30, message = "LastName should be between 6 and 30 characters!")
    String lastName;
    @NotEmpty(message = "phoneNumber should not be empty!")
    @Size(min = 6, max = 30, message = "phoneNumber must be between 6 and 30 characters!")
    String phoneNumber;
    @NotEmpty(message = "email should not be empty!")
    @Size(min = 5, max = 30, message = "email must be between 5 and 30 characters!")
    String email;
    @NotEmpty(message = "password is mandatory!")
    @Size(min = 6, max = 20, message = "password must be between 6 and 20 characters!")
    String password;
}