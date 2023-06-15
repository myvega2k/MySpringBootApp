package com.ktds.myspringboot.service;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.entity.UserEntity;
import com.ktds.myspringboot.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserEntityService {
    private final UserEntityRepository repository;
    private final ModelMapper modelMapper;
    //constructor injection
//    public UserEntityService(UserEntityRepository repository, ModelMapper modelMapper) {
//        this.repository = repository;
//        this.modelMapper = modelMapper;
//    }

    public UserResponse insertUser(UserRequest userRequest) {
        UserEntity userEntity = UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build();
        UserEntity savedUser = repository.save(userEntity);

    }

}
