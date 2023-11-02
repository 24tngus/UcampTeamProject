package com.mission.mymission.repository;

import com.mission.mymission.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByStoreid(String storeid);
    List<Review> findByStorename(String storename);

    Review findBySeq(int seq);

    Review findBySeq(Long seq);

    List<Review> findByWriterContaining(String writer);

    List<Review> searchByStorename(String storename);

    @Transactional
    @Modifying
    @Query("update Review r set r.content= :content, r.image= :image where r.seq=:seq")
    void updateReview(@Param("seq")int seq, @Param("content") String content, @Param("image") String image);

    List<Review> findByStoreidIsNotNull();

    List<Review> findTop5ByStoreidIsNotNullOrderBySeqDesc(PageRequest of);
}