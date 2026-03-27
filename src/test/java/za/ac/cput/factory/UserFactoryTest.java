

/*
Aneeqah Talaaboedien
Student number 219099405
March 2026
*/


package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;


public class UserFactoryTest {

    @Test
    void testCreateUserSuccess() {
        User user = UserFactory.createUser("U001", "Aneeqah", "anee@example.com", "pass123");

        assertNotNull(user);
        assertEquals("U001", user.getUserId());
        assertEquals("Aneeqah", user.getUserName());
        assertEquals("anee@example.com", user.getEmail());
        assertEquals("pass123", user.getPassword());
    }

    @Test
    void testCreateUserNullId() {
        User user = UserFactory.createUser(null, "Aneeqah", "anee@example.com", "pass123");
        assertNull(user);
    }

    @Test
    void testCreateUserEmptyName() {
        User user = UserFactory.createUser("U001", "", "anee@example.com", "pass123");
        assertNull(user);
    }

    @Test
    void testCreateUserNullEmail() {
        User user = UserFactory.createUser("U001", "Aneeqah", null, "pass123");
        assertNull(user);
    }

    @Test
    void testCreateUserNullPassword() {
        User user = UserFactory.createUser("U001", "Aneeqah", "anee@example.com", null);
        assertNull(user);
    }
}
