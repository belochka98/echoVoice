package com.echoVoice.controller;

import com.echoVoice.controller.utills.response.ResultResponse;
import com.echoVoice.dto.AccountDto;
import com.echoVoice.dto.envers.RevisionDto;

import java.util.Collection;

public interface AccountController {
    ResultResponse<AccountDto> getAccountById(String accountId);

    ResultResponse<Collection<AccountDto>> getAllAccounts();

    ResultResponse<AccountDto> saveAccount(AccountDto account);

    void deleteAccount(String accountId);

    Collection<RevisionDto> getAllRevisions(String accountId);

    RevisionDto getLastRevision(String accountId);
}
