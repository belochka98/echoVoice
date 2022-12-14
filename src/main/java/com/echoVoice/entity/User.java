package com.echoVoice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "user_application")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Audited
public class User {
    @Id
    @EqualsAndHashCode.Include
    private String id = UUID.randomUUID().toString();

    @Column(name = "active")
    private boolean active;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_birthday")
    private LocalDate dateBirthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private boolean sex;
}
