package com.mission.mymission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mission.mymission.entity.Store;

import java.util.List;
import java.util.Optional;


public interface StoreRepository extends JpaRepository<Store, Integer> {
//    List<Store> findBySeqIn(List<Integer> seq); // seq list
    Store findByEmail(String email);
    Store findBySeq(int seq);
    Store findBySeq(Long seq);
}