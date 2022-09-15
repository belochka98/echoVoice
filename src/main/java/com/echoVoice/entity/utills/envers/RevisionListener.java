package com.echoVoice.entity.utills.envers;

public class RevisionListener implements org.hibernate.envers.RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        ((RevisionEntity) revisionEntity).setUsername("belochka");
    }
}