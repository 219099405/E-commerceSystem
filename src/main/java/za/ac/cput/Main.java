/*
 * Main.java
 * Pertunia Sifunda (221692568)
 */
package za.ac.cput;

import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        OrderRepository repository = OrderRepository.getInstance();

        Order order1 = OrderFactory.createOrder("user-001", LocalDate.of(2026, 3, 27));
        Order order2 = OrderFactory.createOrder("user-002", LocalDate.of(2026, 3, 20));

        System.out.println(" Create ");
        System.out.println("Created: " + repository.create(order1));
        System.out.println("Created: " + repository.create(order2));

        System.out.println("\nRead ");
        System.out.println("Read order1: " + repository.read(order1.getOrderId()));

        System.out.println("\nUpdate ");
        Order updated = new Order.Builder()
                .copy(order1)
                .setDate(LocalDate.of(2026, 4, 1))
                .build();
        System.out.println("Updated: " + repository.update(updated));
        System.out.println("Verified from repo: " + repository.read(order1.getOrderId()));

        System.out.println("\nDelete ");
        System.out.println("Deleted order2: " + repository.delete(order2.getOrderId()));
        System.out.println("Read order2 after delete (should be null): "
                + repository.read(order2.getOrderId()));

        System.out.println("\nAll Orders ");
        repository.getAll().forEach(System.out::println);
    }
}