package za.ac.cput.repository;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void createCart_Success() {
        // Testing manual cart creation
        Cart cart = CartFactory.createCart("CRT-001", "USER-ABC");
        assertNotNull(cart);
        assertEquals("CRT-001", cart.getCartId());
    }

    @Test
    void createEmptyCartForUser_Success() {
        // Testing automated ID generation
        Cart cart = CartFactory.createEmptyCartForUser("USER-ABC");
        assertNotNull(cart);
        assertTrue(cart.getCartId().startsWith("CART-"));
        assertEquals("USER-ABC", cart.getUserId());
    }

    @Test
    void createCart_Failure() {
        // Testing validation logic
        assertThrows(IllegalArgumentException.class, () -> {
            CartFactory.createCart(null, "USER-ABC");
        });
    }
}


