package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends ListCrudRepository<UserEntity,Long> {
    List<UserEntity> findByName(String name);
    Optional<UserEntity> findByEmail(String email);
}
