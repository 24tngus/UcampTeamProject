package com.mission.mymission.controller;

import com.mission.mymission.entity.*;
import com.mission.mymission.repository.ReviewRepository;
import com.mission.mymission.repository.ShopRegisterRepository;
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
    private final ShopRegisterRepository shopRegisterRepository;

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
    public Map<String, Object> getReviewMap(@CookieValue(value = "token", required = false) String token,
                                            @RequestParam String storename){
        if (!jwtService.isValid(token)) {
            List<Review> reviewList = reviewRepository.findByStorename(storename);
            Collections.reverse(reviewList);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("reviewList", reviewList);
            return resultMap;
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);
        String nickname = users.getNickname();
        List<Review> reviewList = reviewRepository.findByStorename(storename);
        Collections.reverse(reviewList);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("nickname", nickname);
        resultMap.put("reviewList", reviewList);

        return resultMap;
    }
    @GetMapping("/myreview")
    public List<Review> getMyReview(@CookieValue(value = "token", required = false) String token){
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);
        List<Review> reviewList = reviewRepository.findByWriterContaining(users.getNickname());
        Collections.reverse(reviewList);
        return reviewList;
    }

    @PutMapping("/review/insert/{storename}")
    public ResponseEntity<Review> insertReview(@CookieValue(value = "token", required = false) String token, @PathVariable String storename,@RequestBody Review newReview){
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);
        System.out.println("스토어네임" + storename);
//        Review storeid = reviewRepository.findBystorename(storename);
        ShopRegister shopRegister = shopRegisterRepository.findByStorename(storename);
        String storeid = shopRegister.getStoreid();

        System.out.println("스토어아이디" + storeid);

//        String storeid = newReview.getStoreid();
        String writer = users.getNickname();
        Review review = new Review();
        review.setStorename(storename);
        review.setStoreid(storeid);
        review.setWriter(writer);
        review.setContent(newReview.getContent());
        review.setImage(newReview.getImage());
        review.setStar(newReview.getStar());
        review.setStatus(1);
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
        updateReviewPro.setStar(updateReview.getStar());
        reviewRepository.save(updateReviewPro);
        return ResponseEntity.ok("Review updated successfully");
    }
}