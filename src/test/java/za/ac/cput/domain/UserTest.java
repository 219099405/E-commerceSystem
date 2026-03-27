
/*
Aneeqah Talaaboedien
Student number 219099405
March 2026
*/



package za.ac.cput.domain;
import org.junit.jupiter.api.*;
import za.ac.cput.factory.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        user1 = UserFactory.createUser("U001", "Aneeqah", "anee@example.com", "pass123");
        user2 = UserFactory.createUser("U002", "John", "john@example.com", "pass456");
        user3 = UserFactory.createUser("U003", "Sarah", "sarah@example.com", "pass789");
    }

    @Test
    @Order(1)
    void testUser1NotNull() {
        assertNotNull(user1);
    }

    @Test
    @Order(2)
    void testUser2NotNull() {
        assertNotNull(user2);
    }

    @Test
    @Order(3)
    void testUser3NotNull() {
        assertNotNull(user3);
    }

    @Test
    @Order(4)
    void testGetUserId() {
        assertEquals("U001", user1.getUserId());
    }

    @Test
    @Order(5)
    void testGetUserName() {
        assertEquals("Aneeqah", user1.getUserName());
    }

    @Test
    @Order(6)
    void testGetEmail() {
        assertEquals("anee@example.com", user1.getEmail());
    }

    @Test
    @Order(7)
    void testGetPassword() {
        assertEquals("pass123", user1.getPassword());
    }

    @Test
    @Order(8)
    void testToString() {
        String result = user1.toString();

        assertNotNull(result);
        assertTrue(result.contains("Aneeqah"));
        assertTrue(result.contains("anee@example.com"));
    }
}
