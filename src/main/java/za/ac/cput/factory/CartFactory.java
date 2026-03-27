package za.ac.cput.factory;

import za.ac.cput.domain.Cart;


public class CartFactory {
    public static Cart createCart(String cartId, String userId) {
        if (cartId == null || userId == null) {
            throw new IllegalArgumentException("Cart ID and User ID cannot be null");
        }
        return new Cart.Builder()
                .cartId(cartId)
                .userId(userId)
                .build();
    }
        public static Cart createEmptyCartForUser (String userId){
            String generatedId = "CART-" + System.currentTimeMillis();
            return new Cart.Builder()
                    .cartId(generatedId)
                    .userId(userId)
                    .build();


    }
}