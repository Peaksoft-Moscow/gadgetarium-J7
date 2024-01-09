package com.peaksoft.gadgetariumj7.model.dto;

import com.peaksoft.gadgetariumj7.model.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {
    private String token;
    private Role roleName;
}
