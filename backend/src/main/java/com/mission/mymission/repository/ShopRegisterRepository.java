package com.mission.mymission.repository;

import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.ShopRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRegisterRepository extends JpaRepository<ShopRegister, Integer> {
    List<ShopRegister> findByStoreid(String storeid);
    ShopRegister findBySeq(int seq);
}