package com.gtt.wxmini.jielongbackend.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UUID;
    private String productName;
    private String imageUrl;
    private String description;
    private double productPrice;
    private int maxNumber;
}
