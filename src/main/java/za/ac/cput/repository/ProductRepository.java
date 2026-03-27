package za.ac.cput.repository.impl;

import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static ProductRepository repository = null;
    private List<Product> productDB;

    private ProductRepository() {
        productDB = new ArrayList<>();
    }

    public static ProductRepository getRepository() {
        if (repository == null) {
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        this.productDB.add(product);
        return product;
    }

    @Override
    public Product read(String productId) {
        return productDB.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Product update(Product product) {
        Product oldProduct = read(product.getProductId());
        if (oldProduct != null) {
            productDB.remove(oldProduct);
            productDB.add(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(String productId) {
        Product productToDelete = read(productId);
        if (productToDelete == null) return false;
        productDB.remove(productToDelete);
        return true;
    }

    @Override
    public List<Product> getAll() {
        return productDB;
    }
}
