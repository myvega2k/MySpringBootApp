package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.UserInfo;
import org.springframework.data.repository.ListCrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserInfoRepository extends ListCrudRepository<UserInfo, Integer> {
    Optional<UserInfo> findByEmail(String username);
}
