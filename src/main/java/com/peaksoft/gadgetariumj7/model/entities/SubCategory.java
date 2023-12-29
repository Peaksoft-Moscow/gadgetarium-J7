package com.peaksoft.gadgetariumj7.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "subCategory_id")
    Category categoryOfSubCategory;
}