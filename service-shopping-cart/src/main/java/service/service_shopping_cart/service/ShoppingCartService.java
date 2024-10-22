package service.service_shopping_cart.service;

import service.service_shopping_cart.entity.CartItem;
import service.service_shopping_cart.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartService {

    //crear carrito
    ShoppingCart getOrCreateCart(int idUser);
    //Agregar item
    CartItem addItemCart(int idCart, int idProduct, int quantity, BigDecimal unitPrice);
    //Listar Items
    List<CartItem> listItemCart(int idCart);
}
