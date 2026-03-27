package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    @Test
    void testCreateProduct() {
        Product p = ProductFactory.createProduct("Laptop", 15000.00);
        assertNotNull(p);
        System.out.println(p.toString());
    }
}
