/*
 * OrderRepositoryImpl.java
 * Pertunia Sifunda (221692568)
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    private static OrderRepository instance = null;
    private final List<Order> orderList;

    private OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    @Override
    public Order create(Order order) {
        if (order == null || order.getOrderId() == null) {
            return null;
        }
        orderList.add(order);
        return order;
    }

    @Override
    public Order read(String id) {
        if (id == null) {
            return null;
        }
        return orderList.stream()
                .filter(o -> o.getOrderId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (order == null || order.getOrderId() == null) {
            return null;
        }
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId().equals(order.getOrderId())) {
                orderList.set(i, order);
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        if (orderId == null) {
            return false;
        }
        return orderList.removeIf(o -> o.getOrderId().equals(orderId));
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orderList);
    }

}
