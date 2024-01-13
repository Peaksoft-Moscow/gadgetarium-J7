package com.peaksoft.gadgetariumj7.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailingResponse {

    Long id;
    String email;
    String sender;
    String massage;
    String mailingName;
    String newsletterDescription;
    String image;
    LocalDate promotionStartDate;
    LocalDate promotionEndDate;
    LocalDate createDate;
}