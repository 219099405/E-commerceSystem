package za.ac.cput.domain;

public class Product {

    private String productId;
    private  String productName;
    private double price;

    private Product() {

    }

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.price = builder.price;
    }

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

        public Product build() {
            return new Product(this);
        }
    }
}
