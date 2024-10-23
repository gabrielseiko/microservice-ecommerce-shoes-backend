package service.service_shopping_cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart_item")
    private int idCartItem;

    @ManyToOne
    @JoinColumn(name = "id_cart", nullable = false)
    private ShoppingCart shoppingCart;

    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "subtotal_price")
    private BigDecimal subTotalPrice;
}
