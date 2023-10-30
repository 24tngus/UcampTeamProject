package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu")
@Getter @Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(nullable = false)
    private int shopseq;

    @Column(length = 400, nullable = false)
    private String menu;

    @Column(length = 400)
    private String info;

    @Column(length = 4000)
    private String image;

    @Column(nullable = false)
    private int sale;

    @Column(nullable = false)
    private int price;
}