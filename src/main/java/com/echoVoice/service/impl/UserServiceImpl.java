package com.echoVoice.service.impl;

import com.echoVoice.entity.User;
import com.echoVoice.repository.UserRepository;
import com.echoVoice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Collection<User> saveUsers(Collection<User> users) {
        return users
                .stream()
                .map(this::saveUser)
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Revisions<Long, User> getRevisions(String userId) {
        return userRepository.findRevisions(userId);
    }

    @Override
    public Revision<Long, User> getLastRevision(String userId) {
        return userRepository.findLastChangeRevision(userId).orElse(null);
    }
}
