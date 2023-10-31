package com.mission.mymission.repository;


import com.mission.mymission.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findBySeqIn(List<Integer> seq); // seq list
    List<Shop> findByCategory(String category);
    Shop findBySeq(Long seq);
    List<Shop> findByPermit(int i);

    Shop findBySeq(int seq);
}