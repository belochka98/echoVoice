package com.echoVoice.entity;

import com.echoVoice.entity.utills.enums.AccountTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "account_type")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountType {
    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private String id = UUID.randomUUID().toString();

    @Column(name = "active")
    private boolean active;

    @Column(name = "name")
    @Enumerated(STRING)
    private AccountTypeName name;
}
