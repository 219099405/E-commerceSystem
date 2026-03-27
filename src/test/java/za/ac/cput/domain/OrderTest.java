package za.ac.cput.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
 * OrderTest.java
 * Pertunia Sifunda (221692568)
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderTest {

    private za.ac.cput.domain.Order order1;
    private za.ac.cput.domain.Order order2;
    private za.ac.cput.domain.Order order3;

    @BeforeEach
    void setUp() {
        order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 1, 10));
        order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 2, 15));
        order3 = OrderFactory.createOrder("user-003", LocalDate.of(2026, 3, 27));
    }

    @Test
    @Order(1)
    void testOrder1IsNotNull() {
        assertNotNull(order1);
    }

    @Test
    @Order(2)
    void testOrder2IsNotNull() {
        assertNotNull(order2);
    }

    @Test
    @Order(3)
    void testOrder3IsNotNull() {
        assertNotNull(order3);
    }

    @Test
    @Order(4)
    void testGetOrderId() {
        assertNotNull(order1.getOrderId());
        assertFalse(order1.getOrderId().isEmpty());
    }

    @Test
    @Order(5)
    void testGetUserId() {
        assertEquals("user-001", order1.getUserId());
        assertEquals("user-002", order2.getUserId());
        assertEquals("user-003", order3.getUserId());
    }

    @Test
    @Order(6)
    void testGetDate() {
        assertEquals(LocalDate.of(2026, 1, 10), order1.getDate());
        assertEquals(LocalDate.of(2026, 2, 15), order2.getDate());
        assertEquals(LocalDate.of(2026, 3, 27), order3.getDate());
    }

    @Test
    @Order(7)
    void testBuilderCopy() {
        za.ac.cput.domain.Order copy = new za.ac.cput.domain.Order.Builder()
                .copy(order1)
                .build();

        assertNotNull(copy);
        assertEquals(order1.getOrderId(), copy.getOrderId());
        assertEquals(order1.getUserId(), copy.getUserId());
        assertEquals(order1.getDate(), copy.getDate());
    }

    @Test
    @Order(8)
    void testToString() {
        String result = order1.toString();

        assertNotNull(result);
        assertTrue(result.contains("user-001"));
        assertTrue(result.contains("2026-01-10"));
    }

}