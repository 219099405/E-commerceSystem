/*
 * OrderRepositoryTest.java - Test class for OrderRepository
 * Pertunia Sifunda (221692568)
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderRepositoryTest {

    private static OrderRepository repository;
    private static Order order;

    @BeforeAll
    static void setUp() {
        repository = OrderRepository.getInstance();
        order = OrderFactory.createOrder("user-001", LocalDate.of(2026, 3, 20));
        repository.create(order);
    }

    @Test
    @org.junit.jupiter.api.Order(1)  // Fix: fully qualified to avoid clash with za.ac.cput.domain.Order
    void create() {
        Order created = repository.create(order);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        Order read = repository.read(order.getOrderId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void update() {
        Order updated = new Order.Builder()
                .copy(order)
                .setUserId("user-999")
                .setDate(LocalDate.of(2026, 6, 1))
                .build();
        Order result = repository.update(updated);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void delete() {
        Order temp = OrderFactory.createOrder("user-temp", LocalDate.of(2026, 1, 1));
        repository.create(temp);
        boolean success = repository.delete(temp.getOrderId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void getAll() {
        List<Order> all = repository.getAll();
        assertFalse(all.isEmpty());
        System.out.println(all);
    }
}