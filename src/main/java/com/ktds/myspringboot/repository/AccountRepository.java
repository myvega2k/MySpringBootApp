package com.ktds.myspringboot.repository;

import com.ktds.myspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
