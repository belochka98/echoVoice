package com.echoVoice.entity.utills.envers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.history.RevisionMetadata;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "revision_changes_envers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RevisionChange {
    @Id
    @EqualsAndHashCode.Include
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private CustomTrackingRevisionEntity revision;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "entity_name")
    private String entityClassName;

    @Column(name = "revision_operation")
    private RevisionMetadata.RevisionType operation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RevisionChange that = (RevisionChange) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}