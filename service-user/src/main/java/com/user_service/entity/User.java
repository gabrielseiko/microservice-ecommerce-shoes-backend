package com.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dni")
    private String dni;
    @Column(name = "phone")
    private String phone;
    @Column(name = "state")
    private boolean state;
    @Column(name = "date_register", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegister;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_user_has_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;
}
