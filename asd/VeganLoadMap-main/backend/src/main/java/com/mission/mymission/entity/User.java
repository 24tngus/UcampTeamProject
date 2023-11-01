package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter @Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(length = 100, nullable = false, unique = true)
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 4000, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String tel;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime req = LocalDateTime.now();

    @Column(nullable = false)
    private int status;

    @Column(length = 100, nullable = false, unique = true)
    private String nickname;
}
