package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductRepositoryTest.java
 * TDD for Product Repository Implementation
 * Author: Sinentlantla Slayi (222133872)
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest {
    private static ProductRepository repository = ProductRepository.getRepository();
    private static Product product = ProductFactory.createProduct("iPhone 15", 18000.00);

    @Test
    @Order(1)
    void testCreate() {
        Product created = repository.create(product);
        assertNotNull(created);
        assertEquals(product.getProductId(), created.getProductId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void testRead() {
        Product read = repository.read(product.getProductId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void testGetAll() {
        System.out.println("Show All: " + repository.getAll());
        assertFalse(repository.getAll().isEmpty());
    }
}
