package com.mission.mymission.repository;


import com.mission.mymission.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopRepository extends JpaRepository<Shop, Integer> {
}