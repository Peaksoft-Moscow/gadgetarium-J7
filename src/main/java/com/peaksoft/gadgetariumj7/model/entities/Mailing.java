package com.peaksoft.gadgetariumj7.model.entities;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "mailing")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mailing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String sender;
    @Column(name = "mailing_name")
    String mailingName;
    @Column(name = "newsletter_description")
    String newsletterDescription;
    String massage;
    String image;
    @Column(name = "promotion_start_date")
    LocalDate promotionStartDate;
    @Column(name = "promotion_end_date")
    LocalDate promotionEndDate;
    LocalDate createDate;
}