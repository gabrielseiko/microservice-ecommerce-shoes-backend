package service.service_shopping_cart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.service_shopping_cart.client.UserServiceClient;
import service.service_shopping_cart.entity.CartItem;
import service.service_shopping_cart.entity.ShoppingCart;
import service.service_shopping_cart.repository.CartItemRepository;
import service.service_shopping_cart.repository.ShoppingCartRepository;
import service.service_shopping_cart.service.ShoppingCartService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartService {


    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private  CartItemRepository cartItemRepository;
    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public ShoppingCart getOrCreateCart(int idUser) {
        userServiceClient.findById(idUser);
        Optional<ShoppingCart> existingCart = shoppingCartRepository.findByIdUserAndState(idUser, "active");
        return existingCart.orElseGet(() -> createCart(idUser));
    }
    private ShoppingCart createCart(Integer idUser) {
        ShoppingCart objCart = new ShoppingCart();
        objCart.setIdUser(idUser);
        objCart.setTotalPrice(BigDecimal.ZERO);
        objCart.setState("active");
        objCart.setDateCreate(new Date());
        return shoppingCartRepository.save(objCart);
    }

    @Override
    public CartItem addItemCart(int idCart, int idProduct, int quantity, BigDecimal unitPrice) {
        ShoppingCart cart = shoppingCartRepository.findById(idCart).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        CartItem item = new CartItem();
        item.setShoppingCart(cart);
        item.setIdProduct(idProduct);
        item.setQuantity(quantity);
        item.setUnitPrice(unitPrice);
        item.setSubTotalPrice(unitPrice.multiply(new BigDecimal(quantity)));
        cartItemRepository.save(item);

        cart.setTotalPrice(cart.getTotalPrice().add(item.getSubTotalPrice()));
        shoppingCartRepository.save(cart);

        return item;
    }

    @Override
    public List<CartItem> listItemCart(int idCart) {
        return cartItemRepository.findAllByShoppingCart_IdCart(idCart);
    }
}
