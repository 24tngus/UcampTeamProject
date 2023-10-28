package com.mission.mymission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mission.mymission.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findBySeq(Long seq);

    List<Review> findByWriterContaining(String writer); // 작성자 이름으로 검색

    List<Review> findByShopseq(Long shopseq); // 가게 번호로 검색


}