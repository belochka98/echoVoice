package com.echoVoice.mapper;

import com.echoVoice.dto.RevisionChangeDto;
import com.echoVoice.dto.RevisionDto;
import com.echoVoice.entity.utills.envers.RevisionChange;
import com.echoVoice.entity.utills.envers.RevisionEntityCustom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.history.Revision;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;

@Mapper(componentModel = "spring", imports = {LocalDate.class, Instant.class, ZoneId.class, RevisionEntityCustom.class}, uses = RevisionMapper.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RevisionMapper {
    RevisionMapper MAPPER = Mappers.getMapper(RevisionMapper.class);

    @Mapping(target = "revisionId", expression = "java(revision.getRequiredRevisionNumber().longValue())")
    @Mapping(target = "revisionOperation", expression = "java(revision.getMetadata().getRevisionType())")
    @Mapping(target = "revisionDate", expression = "java(LocalDate.ofInstant(revision.getMetadata().getRequiredRevisionInstant(), ZoneId.systemDefault()))")
    @Mapping(target = "revisionUserName", expression = "java(((RevisionEntityCustom) revision.getMetadata().getDelegate()).getUsername())")
    @Mapping(target = "revisionObject", expression = "java(revision.getEntity())")
    RevisionDto apply(Revision revision);

    Collection<RevisionDto> mapRevisions(Collection<Revision> revisions);

    @Mapping(target = "revisionId", source = "id")
    @Mapping(target = "revisionDate", expression = "java(Instant.ofEpochMilli(revision.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate())")
    @Mapping(target = "revisionUserName", source = "username")
    @Mapping(target = "revisionObject", ignore = true)
    @Mapping(target = "revisionOperation", ignore = true)
    RevisionDto apply(RevisionEntityCustom revision);

    // @Mapping(target="revision", expression = "java(this.apply(revisionChange.getRevision()))")
    RevisionChangeDto apply(RevisionChange revisionChange);

    //  Collection<RevisionChangeDto> mapRevisionChanges(Collection<RevisionChange> revisionChanges);
}
