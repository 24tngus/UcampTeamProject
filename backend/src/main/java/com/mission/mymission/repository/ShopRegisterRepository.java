package com.mission.mymission.repository;

import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.ShopRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRegisterRepository extends JpaRepository<ShopRegister, Integer> {
    ShopRegister findBySeq(Long seq);

    List<ShopRegister> findByPermit(int i);

    Long countByPermit(int i);

    ShopRegister findByStorename(String storename);
}
