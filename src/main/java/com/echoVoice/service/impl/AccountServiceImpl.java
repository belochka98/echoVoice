package com.echoVoice.service.impl;

import com.echoVoice.entity.Account;
import com.echoVoice.entity.UserAccount;
import com.echoVoice.repository.AccountRepository;
import com.echoVoice.repository.UserAccountRepository;
import com.echoVoice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserAccountRepository userAccountRepository;

    @Override
    public Account getAccount(String accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public Collection<Account> saveAccounts(Collection<Account> accounts) {
        Set<Account> savedAccounts = accounts
                .stream()
                .map(this::saveAccount)
                .collect(Collectors.toSet());

        return savedAccounts;
    }

    @Override
    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Collection<Account> getUserAccounts(String userId) {
        return userAccountRepository
                .findAllByUserId(userId)
                .stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toSet());
    }

    @Override
    public Revisions<Long, Account> getRevisions(String accountId) {
        return accountRepository.findRevisions(accountId);
    }

    @Override
    public Revision<Long, Account> getLastRevision(String accountId) {
        return accountRepository.findLastChangeRevision(accountId).orElse(null);
    }
}
