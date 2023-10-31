package com.mission.mymission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Table(name = "reservesetting")
@Setter
@Getter
@Entity
public class ReserveSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(length = 100)
    private String storeid;

    @Column(nullable = false)
    private int team;

    @Column(nullable = false)
    private int people;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @Column
    private Integer time0810;

    @Column
    private Integer time1012;

    @Column
    private Integer time1214;

    @Column
    private Integer time1416;

    @Column
    private Integer time1618;

    @Column
    private Integer time1820;

    @Column
    private Integer time2022;


    @Override
    public String toString(){
        return "Reservesetting" + "seq=" + seq + "storeid=" + storeid + "team=" + team + "people=" + people + "date=" + date
                + "time0810=" + time0810 + "time1012=" + time1012 + "time1214=" + time1214 + "time1416=" + time1416 + "time1618=" + time1618 + "time1820=" + time1820
                + "time2022=" + time2022;
    }
}