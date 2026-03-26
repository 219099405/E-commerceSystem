package domain;

public class Cart {

    private String cartId;
    private String userId;

    // Private constructor for the Builder
    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.userId = builder.userId;
    }

    // Getters
    public String getCartId() {
        return cartId;
    }

    public String getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", userId=" + userId + "]";
    }


    public static class Builder {
        private String cartId;
        private String userId;

        public Builder() {}

        public Builder cartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }

}
