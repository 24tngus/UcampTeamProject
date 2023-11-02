package com.mission.mymission.repository;

import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.ShopRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ShopRegisterRepository extends JpaRepository<ShopRegister, Integer> {
    List<ShopRegister> findByStoreid(String storeid);

    @Query("SELECT s FROM ShopRegister s WHERE s.storeid = :storeid")
    ShopRegister findSingleByStoreid(@Param("storeid") String storeid);

    ShopRegister findBySeq(int seq);

    ShopRegister findBySeq(Long seq);

    List<ShopRegister> findBySeqIn(List<Integer> seq); // seq list

    ShopRegister findByStorename(String storename);

    List<ShopRegister> findByPermit(int i);

    Long countByPermit(int i);
}

