package com.mission.mymission.repository;

import com.mission.mymission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String id);
    User findBySeq(int seq);
    User findByNickname(String nickname);

    User findByEmail(String email);
}