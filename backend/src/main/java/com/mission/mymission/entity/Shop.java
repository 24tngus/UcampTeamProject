package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shop")
@Getter @Setter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(length = 100, nullable = false)
    private String storename;

    @Column(length = 400, nullable = false)
    private String title;

    @Column(length = 4000)
    private String detail;

    @Column(length = 100)
    private String category;

    @Column(length = 4000)
    private String location;

    @Column(length = 400)
    private String fileupload;
}
