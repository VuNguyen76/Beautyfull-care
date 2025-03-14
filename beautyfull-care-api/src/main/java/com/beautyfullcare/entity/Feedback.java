package com.beautyfullcare.entity;

import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.entity.Specialist;
import com.beautyfullcare.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private BeautyService service;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Specialist therapist;

    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
