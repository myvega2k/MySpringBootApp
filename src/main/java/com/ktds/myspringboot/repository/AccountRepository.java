package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    //select * from account where username=?
    Optional<Account> findByUsername(String username);
}
