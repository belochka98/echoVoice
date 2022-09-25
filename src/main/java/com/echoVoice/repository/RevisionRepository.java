package com.echoVoice.repository;

import com.echoVoice.dto.filter.RevisionFilterDto;
import com.echoVoice.entity.envers.RevisionChange;

import java.util.Collection;

public interface RevisionRepository {
    Collection<RevisionChange> findRevisions(RevisionFilterDto filter);
}