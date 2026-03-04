package com.blackrock.qa.api_automation;

import java.util.List;

public class CreateOrderRequest {

    private Order order;

    public CreateOrderRequest(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public static class Order {
        private String orderId;
        private Customer customer;
        private List<Item> items;
        private Payment payment;

        public Order(String orderId, Customer customer,
                     List<Item> items, Payment payment) {
            this.orderId = orderId;
            this.customer = customer;
            this.items = items;
            this.payment = payment;
        }

        public String getOrderId() { return orderId; }
        public Customer getCustomer() { return customer; }
        public List<Item> getItems() { return items; }
        public Payment getPayment() { return payment; }
    }

    public static class Customer {
        private String name;
        private String email;

        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
    }

    public static class Item {
        private String productId;
        private int quantity;
        private double price;

        public Item(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
    }

    public static class Payment {
        private String method;
        private String currency;

        public Payment(String method, String currency) {
            this.method = method;
            this.currency = currency;
        }

        public String getMethod() { return method; }
        public String getCurrency() { return currency; }
    }
}