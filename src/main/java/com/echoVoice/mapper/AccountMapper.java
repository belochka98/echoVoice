package com.echoVoice.mapper;

import com.echoVoice.dto.AccountDto;
import com.echoVoice.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountMapper {
    AccountDto apply(Account account);

    Collection<AccountDto> to(Collection<Account> account);

    @Mapping(target = "id", defaultExpression = "java(UUID.randomUUID().toString())")
    Account apply(AccountDto account);

    Collection<Account> from(Collection<AccountDto> account);
}
