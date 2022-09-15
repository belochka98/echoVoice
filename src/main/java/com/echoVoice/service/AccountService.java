package com.echoVoice.service;

import com.echoVoice.entity.Account;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.util.Collection;

public interface AccountService {
    Account getAccount(String accountId);

    Collection<Account> getAllAccounts();

    Account saveAccount(Account account);

    Collection<Account> saveAccounts(Collection<Account> accounts);

    void deleteAccount(String accountId);

    Collection<Account> getUserAccounts(String userId);

    Revisions<Long, Account> getRevisions(String accountId);

    Revision<Long, Account> getLastRevision(String accountId);
}
