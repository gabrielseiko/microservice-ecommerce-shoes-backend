package service.service_shopping_cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private int idCart;
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @Column(name = "date_create")
    private Date dateCreate;
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> items;
}
