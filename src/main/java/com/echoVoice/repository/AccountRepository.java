package com.echoVoice.repository;

import com.echoVoice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>, RevisionRepository<Account, String, Long> {
}