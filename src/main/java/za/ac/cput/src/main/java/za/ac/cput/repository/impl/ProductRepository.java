package za.ac.cput.repository.impl;
import za.ac.cput.domain.Product;
import java.util.*;

public class ProductRepository {
    private static ProductRepository repository = null;
    private List<Product> productList = new ArrayList<>();

    private ProductRepository() {}

    public static ProductRepository getRepository() {
        if (repository == null) repository = new ProductRepository();
        return repository;
    }

    public Product create(Product product) {
        productList.add(product);
        return product;
    }

    public Product read(String id) {
        return productList.stream().filter(p -> p.getProductId().equals(id)).findAny().orElse(null);
    }
}
