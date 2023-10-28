package com.mission.mymission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mission.mymission.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findBySeq(Long seq);

    List<Review> findByWriterContaining(String writer);

    List<Review> findByShopseq(Long shopseq);

    List<Review> findTop5ByOrderBySeqDesc();

//    List<Review> findByStoreid(String storeid);


}