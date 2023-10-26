package com.mission.mymission.repository;

import com.mission.mymission.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findBySeq(int seq);

    User findByNickname(String nickname);

}
