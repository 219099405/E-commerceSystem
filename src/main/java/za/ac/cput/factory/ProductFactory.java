package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {
    public static Product createProduct(String productName, double price) {
        if (productName == null || productName.isEmpty() || price <= 0) {
            return null;
        }

        String productId = java.util.UUID.randomUUID().toString();

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setPrice(price)
                .build();
    }
}
