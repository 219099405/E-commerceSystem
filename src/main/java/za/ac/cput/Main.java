package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.impl.OrderRepositoryImpl;

import java.time.LocalDate;

/*
 * Main.java
 * Pertunia Sifunda (221692568)
 */

public class Main {
    public static void main(String[] args) {

        OrderRepositoryImpl repository = OrderRepositoryImpl.getInstance();


        Order order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 3, 27));
        Order order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 3, 20));

        repository.create(order1);
        repository.create(order2);

        System.out.println("Created Orders ");
        System.out.println(order1);
        System.out.println(order2);


        Order found = repository.read(order1.getOrderId());
        System.out.println("\nRead Order ");
        System.out.println(found);


        Order updated = new Order.Builder()
                .copy(order1)
                .setDate(LocalDate.of(2026, 4, 1))
                .build();
        repository.update(updated);
        System.out.println("\nUpdated Order ");
        System.out.println(repository.read(order1.getOrderId()));


        boolean deleted = repository.delete(order2.getOrderId());
        System.out.println("\nDeleted order2: " + deleted);


        System.out.println("\nAll Orders ");
        repository.getAll().forEach(System.out::println);
    }
}