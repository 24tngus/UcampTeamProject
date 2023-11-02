package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter @Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(nullable = false)
    private String paymentid;

    @Column(nullable = false)
    private String storename;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at = LocalDateTime.now();
}