package com.echoVoice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.history.RevisionMetadata;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RevisionDto<T> {
    private long revisionId;

    private RevisionMetadata.RevisionType revisionType;

    private LocalDate revisionDate;

    private String userName;

    private T object;
}
