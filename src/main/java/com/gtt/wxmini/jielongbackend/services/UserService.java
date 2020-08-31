package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserService {

    void addUser(User user) throws ExecutionException, InterruptedException;
    User findUserById(long Id);
    User findUserByUserId(long userId);
    User findUserByJielongId(long jielongId);
    void removeUserById(long userId) throws ExecutionException, InterruptedException;
    void update(User user) throws ExecutionException, InterruptedException;
}
