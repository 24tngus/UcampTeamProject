package com.mission.mymission.repository;

import com.mission.mymission.entity.Cart;
import com.mission.mymission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);

    List<User> findBySeq(int seq);
}
