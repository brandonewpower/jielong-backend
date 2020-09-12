package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.User;
import com.gtt.wxmini.jielongbackend.repositories.UserRepository;
import com.gtt.wxmini.jielongbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) throws ExecutionException, InterruptedException {

        userRepository.save(user);
    }

    @Override
    public User findUserByUserId(long userId) {

        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> findAllUserByJielongId(long jielongId) {

        return userRepository.findAllByJielongId(jielongId);
    }

    @Override
    public void removeUserById(long userId) throws ExecutionException, InterruptedException {

        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) throws ExecutionException, InterruptedException {

        userRepository.save(user);
    }
}
