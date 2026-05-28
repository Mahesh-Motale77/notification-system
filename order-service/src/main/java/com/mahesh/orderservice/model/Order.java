package com.mahesh.orderservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "orders")
@Data
@Builder
@ToString
public class Order {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String items;
    private Double amount;

    private OrderStatus orderStatus;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;

    public enum OrderStatus{
        CREATED, CONFIRMED, SHIPPED, DELIVERED
    }
}
