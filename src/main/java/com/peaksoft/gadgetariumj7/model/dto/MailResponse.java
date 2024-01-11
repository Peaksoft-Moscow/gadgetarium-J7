package com.peaksoft.gadgetariumj7.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailResponse {

    Long id;
    String sender;
    String massage;
}
