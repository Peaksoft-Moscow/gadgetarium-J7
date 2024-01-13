package com.peaksoft.gadgetariumj7.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.annotations.Struct;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailingRequest {

    String email;
    String sender;
    String massage;
    String mailingName;
    String newsletterDescription;
    String image;
    LocalDate promotionStartDate;
    LocalDate promotionEndDate;
}