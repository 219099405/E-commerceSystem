/*
 * OrderFactoryTest.java
 * Pertunia Sifunda (221692568)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderFactoryTest {

    @Test
    void testCreateOrder_Success() {
        Order order = OrderFactory.createOrder("user-001", LocalDate.of(2026, 1, 10));

        assertNotNull(order);
        assertNotNull(order.getOrderId());
        assertEquals("user-001", order.getUserId());
        assertEquals(LocalDate.of(2026, 1, 10), order.getDate());
    }

    @Test
    void testCreateOrder_NullUserId_ReturnsNull() {
        Order order = OrderFactory.createOrder(null, LocalDate.of(2026, 1, 10));
        assertNull(order);
    }

    @Test
    void testCreateOrder_EmptyUserId_ReturnsNull() {
        Order order = OrderFactory.createOrder("", LocalDate.of(2026, 1, 10));
        assertNull(order);
    }

    @Test
    void testCreateOrder_NullDate_ReturnsNull() {
        Order order = OrderFactory.createOrder("user-001", null);
        assertNull(order);
    }

    @Test
    void testCreateOrder_GeneratesUniqueIds() {
        Order order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 1, 10));
        Order order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 2, 15));
        Order order3 = OrderFactory.createOrder("user-003", LocalDate.of(2026, 3, 27));

        assertNotEquals(order1.getOrderId(), order2.getOrderId());
        assertNotEquals(order2.getOrderId(), order3.getOrderId());
        assertNotEquals(order1.getOrderId(), order3.getOrderId());
    }
}