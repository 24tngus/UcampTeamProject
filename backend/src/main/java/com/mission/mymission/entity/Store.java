package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "store")
@Getter @Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(length = 100, nullable = false)
    private String id;

    @Column(unique = true, length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String tel;

    @Column(length = 100, nullable = false)
    private String storenumber;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime req = LocalDateTime.now();

    @Column(nullable = false)
    private int status;
}