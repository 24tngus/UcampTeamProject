package com.mission.mymission.repository;


import com.mission.mymission.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserSeq(int userSeq);
    Cart findByUserSeqAndMenuSeq(int userSeq, int menuSeq);
}