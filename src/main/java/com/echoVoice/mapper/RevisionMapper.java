package com.echoVoice.mapper;

import com.echoVoice.dto.RevisionDto;
import com.echoVoice.entity.utills.envers.RevisionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.history.Revision;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;

@Mapper(componentModel = "spring", imports = {LocalDate.class, Instant.class, ZoneId.class, RevisionEntity.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RevisionMapper {
    @Mapping(target = "revisionNumber", expression = "java(revision.getRequiredRevisionNumber().longValue())")
    @Mapping(target = "revisionType", expression = "java(revision.getMetadata().getRevisionType())")
    @Mapping(target = "revisionDate", expression = "java(LocalDate.ofInstant(revision.getMetadata().getRequiredRevisionInstant(), ZoneId.systemDefault()))")
    @Mapping(target = "userName", expression = "java(((RevisionEntity) revision.getMetadata().getDelegate()).getUsername())")
    @Mapping(target = "object", expression = "java(revision.getEntity())")
    RevisionDto apply(Revision revision);

    Collection<RevisionDto> to(Collection<Revision> revisions);
}
