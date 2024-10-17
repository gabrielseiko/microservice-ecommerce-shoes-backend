package com.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id;
    @Column(name = "role_name")
    private String role;
    @Column(name = "role_description")
    private String description;
}
