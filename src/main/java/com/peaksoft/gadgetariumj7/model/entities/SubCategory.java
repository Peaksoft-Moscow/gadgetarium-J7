package com.peaksoft.gadgetariumj7.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sub_categories")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nameOfSubCategory;

    @ManyToOne(cascade = {
            CascadeType.ALL})
    @JoinColumn(name = "category_id")
    Category categoryOfSubCategory;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategory")
    List<Product> products;
}