package com.echoVoice.repository.impl;

import com.echoVoice.dto.filter.RevisionFilterDto;
import com.echoVoice.entity.envers.RevisionChange;
import com.echoVoice.repository.RevisionRepository;
import com.echoVoice.repository.utills.RepositoryUtills;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class RevisionRepositoryImpl implements RevisionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<RevisionChange> entity = RevisionChange.class;

    @Override
    public Collection<RevisionChange> findRevisions(RevisionFilterDto filter) {
        Collection<RevisionChange> result;

        if (CollectionUtils.isNotEmpty(filter.getTableNames()) || CollectionUtils.isNotEmpty(filter.getTableNames())) {
            result = getRevisionsByReader(filter);
        } else {
            result = getRevisionsByHQL(filter);
        }

        return result;
    }

    private Collection<RevisionChange> getRevisionsByReader(RevisionFilterDto filter) {
        final var reader = AuditReaderFactory.get(entityManager);

        return null;
    }

    private Collection<RevisionChange> getRevisionsByHQL(RevisionFilterDto filter) {
        final var sqlSelect = getSqlSelect(filter);

        final var query = entityManager.createQuery(sqlSelect, entity);

        RepositoryUtills.setQueryParametersByFilter(query, filter);

        return query.getResultList();
    }

    private String getSqlSelect(RevisionFilterDto filter) {
        return " select object from "
                + entity.getSimpleName()
                + " object where 1 = 1 "
                + (CollectionUtils.isEmpty(filter.getOperations())
                ? ""
                : " and object.operation in (:operations) ");
    }
}
