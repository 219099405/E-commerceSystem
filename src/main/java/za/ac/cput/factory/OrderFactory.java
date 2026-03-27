/*
 * OrderFactory.java
 * Pertunia Sifunda (221692568)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class OrderFactory {

    public static Order createOrder(String userId, LocalDate date) {

        if (Helper.isNullOrEmpty(userId) || date == null) {
            return null;
        }

        String orderId = Helper.generateId();

        return new Order.Builder()
                .setOrderId(orderId)
                .setUserId(userId)
                .setDate(date)
                .build();
    }

}
