package com.echoVoice.controller;

import com.echoVoice.controller.utills.response.ResultResponse;
import com.echoVoice.dto.envers.RevisionChangeDto;
import com.echoVoice.dto.filter.RevisionFilterDto;

import java.util.Collection;

public interface RevisionController {
    ResultResponse<Collection<RevisionChangeDto>> getRevisionChanges(RevisionFilterDto filter);
}
