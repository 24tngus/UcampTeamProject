package com.mission.mymission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mission.mymission.entity.Store;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findBySeqIn(List<Integer> seq); // seq list

    Store findBySeq(Long seq);

}