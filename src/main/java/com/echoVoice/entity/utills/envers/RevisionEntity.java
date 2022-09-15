package com.echoVoice.entity.utills.envers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name = "revinfo")
@org.hibernate.envers.RevisionEntity(RevisionListener.class)
@Data
public class RevisionEntity {
    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev")
    private long id;

    @RevisionTimestamp
    @Column(name = "revtstmp")
    private long timestamp;

    private String username;
}