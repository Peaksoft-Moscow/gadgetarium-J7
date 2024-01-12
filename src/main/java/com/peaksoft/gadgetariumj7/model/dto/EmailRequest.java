package com.peaksoft.gadgetariumj7.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailRequest {

    String email;
    String sender;
    String massage;
    String mailingName;
    String newsletterDescription;
    String image;
    LocalDate promotionStartDate;
    LocalDate promotionEndDate;
}