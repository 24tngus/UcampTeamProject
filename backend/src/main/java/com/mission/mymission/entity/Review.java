package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter @Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(nullable = false, length = 100)
    private String storeid;

    @Column(nullable = false, length = 100)
    private String storename;

    @Column(nullable = false, length = 100)
    private String writer;

    @Column(nullable = false, length = 4000)
    private String content;

    @Column(length = 4000)
    private String image;

    @Column(nullable = false)
    private int status;

    @Column
    private int star;
}
