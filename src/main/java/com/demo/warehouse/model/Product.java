package com.demo.warehouse.model;


import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "product")
@JsonIgnoreType
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_cod")
    private String productCod;

    @Column(name = "category_name")
    private  String categoryName;

    @Column(name = "product_name")
    private String productName;

    @Column
    private int quantity;

    @Column(name = "UM")
    private String unit;

    @Column
    private String notes;
}
