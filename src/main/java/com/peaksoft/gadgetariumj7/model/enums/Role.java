package com.peaksoft.gadgetariumj7.model.enums;

public enum Role {
    ADMIN,
    USER;

    public String getAuthority() {
        return name();
    }
}