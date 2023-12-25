package com.peaksoft.gadgetariumj7.model.entities;

import com.peaksoft.gadgetariumj7.model.entities.Order;
import com.peaksoft.gadgetariumj7.model.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    String email;
    String phoneNumber;
    String password;
    String userPic;
    String gender;
    String local;
    LocalDateTime lastVisit;
    Role role;
    LocalDate createDate;

    @OneToMany(mappedBy = "user")
    List<Order> orders;

    @OneToMany(mappedBy = "user")
    List<OrderHistory> orderHistories;


}