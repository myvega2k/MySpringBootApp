package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.UserInfo;
import org.springframework.data.repository.ListCrudRepository;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Integer> {
}
