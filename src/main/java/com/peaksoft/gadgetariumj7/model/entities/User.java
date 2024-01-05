package com.peaksoft.gadgetariumj7.model.entities;

import com.peaksoft.gadgetariumj7.model.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_Name")
    String lastName;
    @Column(unique = true)
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
    String password;
    String Confirm_the_password;
    Role role;
    @Column(name = "create_date")
    LocalDate createDate;
    boolean subscribeToTheNewsletter;
    @OneToMany(mappedBy = "user")
    List<Order> orders;

    @OneToMany(mappedBy = "user")
    List<OrderHistory> orderHistories;
}