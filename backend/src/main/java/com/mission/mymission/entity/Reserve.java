package com.mission.mymission.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "reserve")
@Setter @Getter
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(nullable = false)
    private int shopseq;

    @Column(length = 100, nullable = false)
    private String reserver;

    @Column(nullable = false)
    private int team;

    @Column(nullable = false)
    private int people;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Column
    private int time0810;

    @Column
    private int time1012;

    @Column
    private int time1214;

    @Column
    private int time1416;

    @Column
    private int time1618;

    @Column
    private int time1820;

    @Column
    private int time2022;

    @Column(length = 100)
    private String comment;

    @Column
    private int status;
}