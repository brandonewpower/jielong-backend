package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import java.util.concurrent.ExecutionException;

public interface JielongService {

    void addJielong(Jielong jielong) throws ExecutionException, InterruptedException;
    Iterable<Jielong> findAllJielong();
    Jielong findJielongById(long jielongId);
    void removeJielongById(long id) throws ExecutionException, InterruptedException;
    void updateJielong(Jielong jielong) throws ExecutionException, InterruptedException;

}
