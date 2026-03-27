package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import java.util.ArrayList;
import java.util.List;
public class CartRepository implements ICartRepository {

    private static CartRepository instance = null;
    private final List<Cart> cartList;

    private CartRepository() {
        this.cartList = new ArrayList<>();
    }

    public static CartRepository getInstance() {
        if (instance == null) {
            instance = new CartRepository();
        }
        return instance;
    }

    @Override
    public Cart create(Cart cart) {
        if (cart == null || cart.getCartId() == null) {
            return null;
        }
        cartList.add(cart);
        return cart;
    }

    @Override
    public Cart read(String id) {
        if (id == null) {
            return null;
        }
        return cartList.stream()
                .filter(c -> c.getCartId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        if (cart == null || cart.getCartId() == null) {
            return null;
        }
        Cart oldCart = read(cart.getCartId());
        if (oldCart != null) {
            cartList.remove(oldCart);
            cartList.add(cart);
            return cart;
        }
        return null;
    }

    @Override
    public boolean delete(String cartId) {
        if (cartId == null) {
            return false;
        }
        Cart cartToDelete = read(cartId);
        if (cartToDelete == null) {
            return false;
        }
        return cartList.remove(cartToDelete);
    }

    @Override
    public List<Cart> getAll() {
        return new ArrayList<>(cartList);
    }
}
