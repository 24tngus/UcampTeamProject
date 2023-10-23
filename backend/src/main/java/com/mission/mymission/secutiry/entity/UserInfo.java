package com.mission.mymission.secutiry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(unique = true,nullable = false)
    private String id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private Date req;
    @Column(nullable = false)
    private Long status;
    @Column(unique = true, nullable = false)
    private String nickname;
    private String roles;
}