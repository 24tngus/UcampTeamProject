package com.mission.mymission.repository;


import com.mission.mymission.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findBySeqIn(List<Integer> seq); // seq list

    List<Shop> findByCategory(String category);

}