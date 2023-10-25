package com.mission.mymission.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mission.mymission.entity.Review;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.Store;
import com.mission.mymission.entity.User;

import java.util.List;

@Service
@Transactional
public interface AdminService {
    List<User> getUserList();
    void deleteUser(String email);
    User getUser(String email);

    List<Store> getStoreList();

    void deleteStore(Long seq);

    List<Shop> getShopList();

    void deleteShop(Long seq);

    Shop getShop(Long seq);

    List<Review> getReviewList();

    void deleteReview(Long seq);
}
