package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    @Rollback(value = false)
    void insert_select_update() {
        //Account 객체생성
        Account account =
                Account.builder()//AccountBuilder
                .username("ktds")
                .password("1234")
                .build(); //Account
        Account savedAccount = accountRepository.save(account);
        assertEquals("ktds", savedAccount.getUsername());
        Optional<Account> optional = accountRepository.findById(1L);
        if(optional.isPresent()){
            Account existAccount = optional.get();
            log.info("Id = {} Username = {}", existAccount.getId(), existAccount.getUsername());
            System.out.println("id  = "+ existAccount.getId());
            System.out.println("Username  = "+ existAccount.getUsername());
        }
//        Account existAccount2 = accountRepository.findById(10L) //Optional<Account>
//                //orElseThrow(Supplier) T get()
//                .orElseThrow(() -> new RuntimeException("Account Not Found"));
//        System.out.println("Username  = "+ existAccount2.getUsername());
        //findByUsername() 호출하기
        Account existAcct = accountRepository.findByUsername("ktds")
                .orElseGet(() -> Account.builder().build());
        System.out.println(existAcct.getUsername());
        existAcct.setUsername("스프링부트");
    }
}