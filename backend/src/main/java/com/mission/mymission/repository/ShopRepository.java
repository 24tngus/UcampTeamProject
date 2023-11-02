package com.mission.mymission.repository;


import com.mission.mymission.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findByCategory(String category);
    Shop findBySeq(Long seq);
    List<Shop> findByPermit(int i);

    Shop findBySeq(int seq);
    Shop findByStorename(String storename);
    List<Shop> searchByStorename(String storename);

    @Query("SELECT s FROM Shop s WHERE s.lat = :lat AND s.lng = :lng")
    Shop findByLatAndLng(@Param("lat") String lat, @Param("lng") String lng);
}