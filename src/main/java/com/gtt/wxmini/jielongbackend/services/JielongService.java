package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.models.JielongObject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface JielongService {

    long addJielong(Jielong jielong) throws ExecutionException, InterruptedException;
    List<Jielong> findAllJielong();
    Jielong findJielongById(long jielongId);
    void removeJielongById(long id) throws ExecutionException, InterruptedException;
    void updateJielong(Jielong jielong) throws ExecutionException, InterruptedException;

//    long addJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException;
//    List<JielongObject> findAllJielong();
//    JielongObject findJielongById(long jielongId);
//    void removeJielongById(long id) throws ExecutionException, InterruptedException;
//    void updateJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException;



}
