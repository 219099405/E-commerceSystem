package za.ac.cput.repository.impl;

import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * OrderRepositoryImpl.java
 * Pertunia Sifunda (221692568)
 */

public class OrderRepositoryImpl implements IOrderRepository {

    private static OrderRepositoryImpl instance = null;
    private final List<Order> orderList;

    private OrderRepositoryImpl() {
        this.orderList = new ArrayList<>();
    }

    public static OrderRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new OrderRepositoryImpl();
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
