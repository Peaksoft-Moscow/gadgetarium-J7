package com.peaksoft.gadgetariumj7.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "brands")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandEn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String img;

    String name;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "brand_products",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;
}
