package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
 * OrderFactoryTest.java
 * Pertunia Sifunda (221692568)
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderFactoryTest {

    @Test
    @org.junit.jupiter.api.Order(1)
    void testCreateOrder1_Success() {
        Order order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 1, 10));

        assertNotNull(order1);
        assertNotNull(order1.getOrderId());
        assertEquals("user-001", order1.getUserId());
        assertEquals(LocalDate.of(2026, 1, 10), order1.getDate());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void testCreateOrder2_Success() {
        Order order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 2, 15));

        assertNotNull(order2);
        assertNotNull(order2.getOrderId());
        assertEquals("user-002", order2.getUserId());
        assertEquals(LocalDate.of(2026, 2, 15), order2.getDate());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void testCreateOrder3_Success() {
        Order order3 = OrderFactory.createOrder("user-003", LocalDate.of(2026, 3, 27));

        assertNotNull(order3);
        assertNotNull(order3.getOrderId());
        assertEquals("user-003", order3.getUserId());
        assertEquals(LocalDate.of(2026, 3, 27), order3.getDate());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void testCreateOrder_NullUserId_ReturnsNull() {
        Order order = OrderFactory.createOrder(null, LocalDate.of(2026, 1, 10));

        assertNull(order);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void testCreateOrder_EmptyUserId_ReturnsNull() {
        Order order = OrderFactory.createOrder("", LocalDate.of(2026, 1, 10));

        assertNull(order);
    }

    @Test
    @org.junit.jupiter.api.Order(6)
    void testCreateOrder_NullDate_ReturnsNull() {
        Order order = OrderFactory.createOrder("user-001", null);

        assertNull(order);
    }

    @Test
    @org.junit.jupiter.api.Order(7)
    void testCreateOrder_GeneratesUniqueIds() {
        Order order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 1, 10));
        Order order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 2, 15));
        Order order3 = OrderFactory.createOrder("user-003", LocalDate.of(2026, 3, 27));

        assertNotNull(order1);
        assertNotNull(order2);
        assertNotNull(order3);
        assertNotEquals(order1.getOrderId(), order2.getOrderId());
        assertNotEquals(order2.getOrderId(), order3.getOrderId());
        assertNotEquals(order1.getOrderId(), order3.getOrderId());
    }

}