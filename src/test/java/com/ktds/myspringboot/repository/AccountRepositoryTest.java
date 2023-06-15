package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    @Rollback(value = false)
    void insert_select() {
        //Account 객체생성
        Account account =
                Account.builder()//AccountBuilder
                .username("ktds")
                .password("1234")
                .build(); //Account
        Account savedAccount = accountRepository.save(account);
        assertEquals("ktds", savedAccount.getUsername());
    }
}