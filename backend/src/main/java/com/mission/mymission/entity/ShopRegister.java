package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "shop_register")
@Getter @Setter
public class ShopRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(length = 100)
    private String storeid;

    @Column(unique = true, length = 100, nullable = false)
    private String storename;

    @Column(length = 4000)
    private String detailinfo;

    @Column(length = 100)
    private String category;

    @Column(length = 4000)
    private String location;

    @Column(length = 100)
    private String phonenumber;

    @Column(length = 400, nullable = false)
    private String image;

    @Column(length = 400)
    private String image1;

    @Column(length = 400)
    private String image2;

    @Column(length = 400)
    private String image3;

    @Column(length = 400)
    private String image4;

    @Column(length = 400)
    private String image5;

    @Column(nullable = false)
    private int permit;

    @Column(name = "permit_update_time")
    private LocalDateTime permitUpdateTime;
}