package com.peaksoft.gadgetariumj7.model.dto;


import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailResponse {

    Long id;
    String mailingName;
    String newsletterDescription;
    String massage;
    String image;
    LocalDate promotionStartDate;
    LocalDate promotionEndDate;
    LocalDate createDate;
}