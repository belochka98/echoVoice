package com.echoVoice.mapper;

import com.echoVoice.dto.AccountDto;
import com.echoVoice.dto.UserDto;
import com.echoVoice.entity.User;
import com.echoVoice.service.AccountService;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {Strings.class, UUID.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountMapper accountMapper;

    @Mapping(target = "userAccounts", source = "id", qualifiedByName = "fillUserAccounts")
    public abstract UserDto apply(User user);

    public abstract Collection<UserDto> to(Collection<User> users);

    @Mapping(target = "id", expression = "java(Strings.isNotEmpty(user.getId()) ? user.getId() : UUID.randomUUID().toString())")
    public abstract User apply(UserDto user);

    public abstract Collection<User> from(Collection<UserDto> user);

    @Named("fillUserAccounts")
    Collection<AccountDto> fillUserAccounts(String userId) {
        return accountMapper.to(accountService.getUserAccounts(userId));
    }
}
