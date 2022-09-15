package com.echoVoice.dto;

import com.echoVoice.entity.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    private String id;

    private boolean active;

    private String name;

    private String maxCountUsers;

    private AccountType accountType;
}
