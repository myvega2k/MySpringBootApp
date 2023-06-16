package com.ktds.myspringboot.service;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.entity.UserEntity;
import com.ktds.myspringboot.exception.ResourceNotFoundException;
import com.ktds.myspringboot.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> listUser() {
        List<UserEntity> userEntityList = repository.findAll();
        return userEntityList.stream() //Stream<UserEntity>
                .map(entity -> modelMapper.map(entity, UserResponse.class)) //Stream<UserResponse>
                .collect(toList()); //List<UserResponse>
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(long id) {
        UserEntity userEntity = repository.findById(id) //Optional<UserEntity>
                //orElseThrow(Supplier) Supplier의 추상메서드 T get()
                .orElseThrow(() -> new ResourceNotFoundException("Users","id",id));
        return modelMapper.map(userEntity, UserResponse.class);  //UserEntity -> UserReponse로 변환해서 리턴
    }
    @Transactional(readOnly = true)
    public ResponseEntity<?> getUserByEmail(String email){
        Optional<UserEntity> optional = repository.findByEmail(email);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(email +"에 해당하는 User가 존재하지 않습니다!");
        }
    }
}
