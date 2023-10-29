package com.mission.mymission.controller;

import com.mission.mymission.entity.Reserve;
import com.mission.mymission.entity.Review;
import com.mission.mymission.entity.Store;
import com.mission.mymission.entity.User;
import com.mission.mymission.repository.ReviewRepository;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.repository.UserRepository;
import com.mission.mymission.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final JwtService jwtService;

    @GetMapping("/review")
    public List<Review> getReview(@CookieValue(value = "token", required = false) String token){
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);
        String storeid = stores.getId();

        List<Review> review = reviewRepository.findByStoreid(storeid);

        return review;
    }
    @GetMapping("/review/list")
    public Map<String, Object> getReviewMap(@CookieValue(value = "token", required = false) String token){
        if (!jwtService.isValid(token)) {
            List<Review> reviewList = reviewRepository.findAll();
            Collections.reverse(reviewList);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("reviewList", reviewList);
            return resultMap;
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);
        String nickname = users.getNickname();
        List<Review> reviewList = reviewRepository.findAll();
        Collections.reverse(reviewList);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("nickname", nickname);
        resultMap.put("reviewList", reviewList);

        return resultMap;
    }

    @PostMapping("/review/insert")
    public ResponseEntity<Review> insertReview(@CookieValue(value = "token", required = false) String token, @RequestBody Review newReview){
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);

        String storeid = newReview.getStoreid();
        String writer = users.getNickname();
        Review review = new Review();
        review.setStoreid(storeid);
        review.setWriter(writer);
        review.setSeq(newReview.getSeq());
        review.setContent(newReview.getContent());
        review.setImage(newReview.getImage());
        review.setStatus(newReview.getStatus());
        review = reviewRepository.save(review);
        return ResponseEntity.ok(review);
    }
    @DeleteMapping("/review/delete/{seq}")
    public ResponseEntity<String> deleteReview( @PathVariable("seq") int seq) {
        Review review = reviewRepository.findBySeq(seq);
        reviewRepository.delete(review);
        return ResponseEntity.ok("Review deleted successfully");
    }
    @GetMapping("/review/updateForm/{seq}")
    public Review updateListReview(@PathVariable("seq") int seq){
        Review updateReview = reviewRepository.findBySeq(seq);
        return updateReview;
    }

    @PutMapping("/review/update/{seq}")
    public ResponseEntity<String> updateReview(@RequestBody Review updateReview){
        Review updateReviewPro = reviewRepository.findBySeq(updateReview.getSeq());
        updateReviewPro.setContent(updateReview.getContent());
        updateReviewPro.setImage(updateReview.getImage());
        System.out.println("내용" + updateReviewPro.getContent());
        reviewRepository.save(updateReviewPro);
        return ResponseEntity.ok("Review updated successfully");
    }
}
