package com.echoVoice.controller;

import com.echoVoice.controller.utills.response.ResultResponse;
import com.echoVoice.dto.filter.RevisionFilterDto;
import com.echoVoice.entity.utills.envers.RevisionChange;

import java.util.Collection;

public interface RevisionController {
    ResultResponse<Collection<RevisionChange>> getRevisions(RevisionFilterDto filter);
}
