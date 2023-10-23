package com.mission.mymission.secutiry.repository;

import com.mission.mymission.secutiry.entity.UserInfo;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Integer> {
    Optional<UserInfo> findById(String id);
    Optional<UserInfo> findByNickname(String nickname);
}
