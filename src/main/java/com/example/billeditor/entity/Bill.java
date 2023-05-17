package com.example.billeditor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "payment_limit_date")
    private LocalDateTime paymentLimitDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(name = "bill_products",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getPaymentLimitDate() {
        return paymentLimitDate;
    }

    public void setPaymentLimitDate(LocalDateTime paymentLimitDate) {
        this.paymentLimitDate = paymentLimitDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Bill() {
    }

    public Bill(Long id, LocalDateTime date, LocalDateTime paymentLimitDate, PaymentMethod paymentMethod, Client client, List<Product> products) {
        this.id = id;
        this.date = date;
        this.paymentLimitDate = paymentLimitDate;
        this.paymentMethod = paymentMethod;
        this.client = client;
        this.products = products;
    }

    public double getTotal() {
        return this.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}

