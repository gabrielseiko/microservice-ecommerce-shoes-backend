package service.service_shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.service_shopping_cart.entity.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    Optional<ShoppingCart> findByIdUserAndState(Integer idUser, String state);
}
