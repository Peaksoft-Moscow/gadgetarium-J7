package com.peaksoft.gadgetariumj7.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String electronicType;

    @JsonIgnore
    @OneToMany(cascade = {
            CascadeType.ALL}, mappedBy = "categoryOfSubCategory")
    List<SubCategory> subCategories;

//    @OneToOne( mappedBy = "category")
//    Product product;

}