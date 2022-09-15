package com.echoVoice.repository;

import com.echoVoice.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    Collection<UserAccount> findAllByUserId (String userId);
}