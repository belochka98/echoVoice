package com.echoVoice.controller.impl;

import com.echoVoice.controller.RevisionController;
import com.echoVoice.controller.utills.response.ResultResponse;
import com.echoVoice.controller.utills.response.ResultResponseFactory;
import com.echoVoice.dto.envers.RevisionChangeDto;
import com.echoVoice.dto.filter.RevisionFilterDto;
import com.echoVoice.mapper.RevisionMapper;
import com.echoVoice.repository.RevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/revisions")
@CrossOrigin(methods = {GET, POST, DELETE})
@RequiredArgsConstructor
public class RevisionControllerImpl implements RevisionController {
    private final RevisionRepository revisionRepository;
    private final RevisionMapper revisionMapper;
    private final ResultResponseFactory responseFactory;

    @Override
    @GetMapping("/expanded")
    public ResultResponse<Collection<RevisionChangeDto>> getRevisionChanges(RevisionFilterDto filter) {
        return responseFactory.createResponseOk(revisionMapper.mapRevisionChanges(revisionRepository.findRevisions(filter)));
    }
}
