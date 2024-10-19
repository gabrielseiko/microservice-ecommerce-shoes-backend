package com.product.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private int idBrand;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "brand_description")
    private String brandDescription;
}
