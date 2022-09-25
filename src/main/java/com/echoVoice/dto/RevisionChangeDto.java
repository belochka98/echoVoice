package com.echoVoice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.history.RevisionMetadata;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RevisionChangeDto {
    private String id;

    @JsonIgnoreProperties({"revisionObject", "revisionOperation"})
    private RevisionDto revision;

    private String tableName;

    private String entityClassName;

    private RevisionMetadata.RevisionType operation;
}
