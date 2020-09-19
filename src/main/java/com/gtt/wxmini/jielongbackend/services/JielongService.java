package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.models.JielongObject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface JielongService {

    void addJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException;
    List<JielongObject> findAllJielong();
    JielongObject findJielongById(long jielongId);
    void removeJielongById(long id) throws ExecutionException, InterruptedException;
    void updateJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException;



}
