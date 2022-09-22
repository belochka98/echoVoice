package com.echoVoice.entity.utills.envers;

import jakarta.persistence.Table;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.envers.EntityTrackingRevisionListener;
import org.hibernate.envers.RevisionType;
import org.springframework.data.history.RevisionMetadata;

import java.util.Set;

import static org.springframework.data.history.RevisionMetadata.RevisionType.DELETE;
import static org.springframework.data.history.RevisionMetadata.RevisionType.INSERT;
import static org.springframework.data.history.RevisionMetadata.RevisionType.UNKNOWN;
import static org.springframework.data.history.RevisionMetadata.RevisionType.UPDATE;

@Slf4j
public class CustomTrackingRevisionListener implements EntityTrackingRevisionListener {
    @Override
    public void newRevision(Object revisionEntityObject) {
        CustomTrackingRevisionEntity revisionEntity = (CustomTrackingRevisionEntity) revisionEntityObject;

        revisionEntity.setUsername("belochka");
    }

    @Override
    public void entityChanged(Class aClass, String entityName, Object entityObject, RevisionType revisionType, Object revisionEntityObject) {
        CustomTrackingRevisionEntity revisionEntity = (CustomTrackingRevisionEntity) revisionEntityObject;

        RevisionChange revisionChange = new RevisionChange();
        revisionChange.setRevision(revisionEntity);
        revisionChange.setTableName(getTableName(entityName));
        revisionChange.setEntityClassName(entityName);
        revisionChange.setOperation(getOperation(revisionType));

        revisionEntity.setRevisionChanges(Set.of(revisionChange));
    }

    private String getTableName(String entityName) {
        String tableName = "";

        try {
            Class<?> entityClass = Class.forName(entityName);
            Table table = entityClass.getAnnotation(Table.class);
            tableName = table.name();
        } catch (ClassNotFoundException e) {
            log.error("Class with name: {" + entityName + "} not found");
        }

        return tableName;
    }

    private RevisionMetadata.RevisionType getOperation(RevisionType revisionType) {
        RevisionMetadata.RevisionType revisionTypeCustom;

        switch (revisionType) {
            case ADD -> revisionTypeCustom = INSERT;
            case MOD -> revisionTypeCustom = UPDATE;
            case DEL -> revisionTypeCustom = DELETE;
            default -> revisionTypeCustom = UNKNOWN;
        }

        return revisionTypeCustom;
    }
}