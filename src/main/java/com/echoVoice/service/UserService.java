package com.echoVoice.service;

import com.echoVoice.entity.User;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import java.util.Collection;

public interface UserService {
    User getUser(String userId);

    Collection<User> getAllUsers();

    User saveUser(User user);

    Collection<User> saveUsers(Collection<User> users);

    void deleteUser(String userId);

    Revisions<Long, User> getRevisions(String userId);

    Revision<Long, User> getLastRevision(String userId);
}
