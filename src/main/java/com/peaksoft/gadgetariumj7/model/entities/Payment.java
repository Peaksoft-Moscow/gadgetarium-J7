package com.peaksoft.gadgetariumj7.model.entities;

import com.peaksoft.gadgetariumj7.model.enums.PaymentSystem;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    PaymentSystem paymentSystems;

    Long cardNumber;

    int cvc;

    int monthDate;

    int yearDate;

    String userName;



}
