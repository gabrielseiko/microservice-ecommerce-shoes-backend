package com.product.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_size")
public class Size {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_size")
    private int idSize;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "size_number")
    private int sizeNumber;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<Stock> stocks;
}
