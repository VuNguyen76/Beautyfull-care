package com.beautyfullcare.entity;

import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.entity.Specialist;
import com.beautyfullcare.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private BeautyService service;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Specialist therapist;

    private LocalDateTime bookingTime;
    private String status; // PENDING, CONFIRMED, COMPLETED, CANCELLED
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
