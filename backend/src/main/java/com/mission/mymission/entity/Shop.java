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
    private String placeid;

    @Column(length = 4000)
    private String detailinfo;

    @Column(length = 100)
    private String category;

    @Column(length = 4000)
    private String location;

    @Column(length = 100)
    private String rating;

    @Column(length = 100)
    private String phonenumber;

    @Column(length = 100)
    private String lat;

    @Column(length = 100)
    private String lng;

    @Column(length = 400)
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

    //    @Override
//    public String toString(){
//        return "Reservesetting" + "seq=" + seq + "shopseq=" + shopseq + "team=" + team + "people=" + people + "date=" + date
//                + "time0810=" + time0810 + "time1012=" + time1012 + "time1214=" + time1214 + "time1416=" + time1416 + "time1618=" + time1618 + "time1820=" + time1820
//                + "time2022=" + time2022;
//    }
    @Override
    public String toString(){
        return "storename" + storename;
    }
}