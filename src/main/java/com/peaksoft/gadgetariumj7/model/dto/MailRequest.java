package com.peaksoft.gadgetariumj7.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailRequest {

    String sender;
    String massage;
    String email;
    boolean sent;
}
