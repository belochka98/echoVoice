package com.echoVoice.controller;

import com.echoVoice.controller.utills.response.ResultResponse;
import com.echoVoice.dto.UserDto;
import com.echoVoice.dto.envers.RevisionDto;

import java.util.Collection;

public interface UserController {
    ResultResponse<UserDto> getUserById(String userId);

    ResultResponse<Collection<UserDto>> getAllUsers();

    ResultResponse<UserDto> saveUser(UserDto user);

    void deleteUser(String userId);

    Collection<RevisionDto> getAllRevisions(String userId);

    RevisionDto getLastRevision(String userId);

}
