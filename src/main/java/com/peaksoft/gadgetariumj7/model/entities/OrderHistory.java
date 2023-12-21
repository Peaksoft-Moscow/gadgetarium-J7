package com.peaksoft.gadgetariumj7.model.entities;

import com.peaksoft.gadgetariumj7.model.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "delivery_histories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "orderHistory_products",
            joinColumns = @JoinColumn(name = "orderHistory_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

    @OneToOne
    Delivery delivery;

    DeliveryStatus deliveryStatus;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orderHistories")
    List<Order> orders;

    @ManyToOne
    User user;

    LocalDate orderTime;
}