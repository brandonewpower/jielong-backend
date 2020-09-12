package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    void addUser(User user) throws ExecutionException, InterruptedException;
    User findUserByUserId(long userId);
    List<User> findAllUserByJielongId(long jielongId);
    void removeUserById(long userId) throws ExecutionException, InterruptedException;
    void updateUser(User user) throws ExecutionException, InterruptedException;
}
