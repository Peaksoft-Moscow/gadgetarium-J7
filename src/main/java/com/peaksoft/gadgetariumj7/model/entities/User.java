package com.peaksoft.gadgetariumj7.model.entities;

import com.peaksoft.gadgetariumj7.model.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {

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

    String gender;

    String local;

    @Enumerated(EnumType.STRING)
    Role role;

    @Column(name = "create_date")
    LocalDate createDate;
    boolean subscribe;

    String resetCode;

    String confirmPassword;

    @OneToMany(mappedBy = "user")
    List<Order> orders;
    @OneToOne(cascade = CascadeType .ALL, mappedBy = "user")
    Favorites favorites;

    @OneToMany(mappedBy = "user")
    List<OrderHistory> orderHistories;
    @OneToOne(mappedBy = "user")
    Basket basket;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}