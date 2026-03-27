package za.ac.cput.domain;

import java.time.LocalDate;

/**
 * Order.java
 * Order dommain class
 * Pertunia Sifunda (221692568)
 */
public class Order {

    private String orderId;
    private String userId;
    private LocalDate date;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.userId = builder.userId;
        this.date = builder.date;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private String orderId;
        private String userId;
        private LocalDate date;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.userId = order.userId;
            this.date = order.date;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}