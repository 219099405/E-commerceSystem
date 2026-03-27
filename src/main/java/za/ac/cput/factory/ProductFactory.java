package za.ac.cput.factory;
import za.ac.cput.domain.Product;
import java.util.UUID;

public class ProductFactory {
    public static Product createProduct(String productName, double price) {
        if (productName == null || productName.isEmpty() || price <= 0) return null;
        String id = UUID.randomUUID().toString();
        return new Product.Builder().setProductId(id).setProductName(productName).setPrice(price).build();
    }
}
