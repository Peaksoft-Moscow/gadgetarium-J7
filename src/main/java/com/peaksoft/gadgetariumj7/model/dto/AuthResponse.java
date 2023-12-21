package com.peaksoft.gadgetariumj7.model.dto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthResponse {

    Long id;
    String name;
    String lastName;
    String phoneNumber;
    String email;
    LocalDate createDate;
}