/*
Aneeqah Talaaboedien
Student number 219099405
March 2026
*/




package za.ac.cput.repository;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    private static IUserRepository repository;
    private static User user;

    @BeforeAll
    static void setUp() {
        repository = UserRepository.getRepository();
        user = UserFactory.createUser("U001", "Aneeqah", "anee@example.com", "pass123");
        repository.create(user);
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void create() {
        User created = repository.create(user);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        User read = repository.read("Aneeqah");
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void update() {
        User updated = new User.Builder()
                .setUserId("U001")
                .setUserName("Aneeqah")
                .setEmail("newemail@example.com")
                .setPassword("newpass123")
                .build();

        User result = repository.update(updated);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void delete() {
        User temp = UserFactory.createUser("U999", "TempUser", "temp@example.com", "temp123");
        repository.create(temp);

        boolean success = repository.delete("TempUser");
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void getAll() {
        List<User> all = repository.getAll();
        assertFalse(all.isEmpty());
        System.out.println(all);
    }
}
