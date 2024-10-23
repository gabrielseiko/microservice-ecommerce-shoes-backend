package service.service_shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.service_shopping_cart.entity.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findAllByShoppingCart_IdCart(int idCart);

}
