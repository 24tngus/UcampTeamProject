package com.mission.mymission.repository;

import com.mission.mymission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
    User findBySeq(int seq);
    User findByNickname(String nickname);
    User findById(String id);
}