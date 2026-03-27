package za.ac.cput.domain;

 Ntlantla-cput-222133872
import java.util.Objects;

/**
 * Product.java
 * Product model class using Builder Pattern
 * Author: Sinentlantla Slayi (222133872)
 * Date: 27 March 2026
 */
public class Product {
    private String productId;
    private String productName;
    private double price;

    private Product() {}

public class Product {

    private String productId;
    private  String productName;
    private double price;

    private Product() {

    }
master

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.price = builder.price;
    }

 Ntlantla-cput-222133872
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
master

    public static class Builder {
        private String productId;
        private String productName;
        private double price;

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

 Ntlantla-cput-222133872
        public Builder copy(Product product) {
            this.productId = product.productId;
            this.productName = product.productName;
            this.price = product.price;
            return this;
        }


master
        public Product build() {
            return new Product(this);
        }
    }
 Ntlantla-cput-222133872

    @Override
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", productName='" + productName + '\'' + ", price=" + price + '}';
    }

 master
}
