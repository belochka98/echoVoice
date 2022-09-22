package com.echoVoice.mapper;

import com.echoVoice.dto.AccountDto;
import com.echoVoice.entity.Account;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {Strings.class, UUID.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountMapper {
    AccountDto apply(Account account);

    Collection<AccountDto> to(Collection<Account> account);

    @Mapping(target = "id", expression = "java(Strings.isNotEmpty(account.getId()) ? account.getId() : UUID.randomUUID().toString())")
    Account apply(AccountDto account);

    Collection<Account> from(Collection<AccountDto> account);
}
