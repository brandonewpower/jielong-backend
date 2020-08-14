package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import java.util.concurrent.ExecutionException;

public interface JielongService {

    void addRequest(Jielong jielong) throws ExecutionException, InterruptedException;
    Iterable<Jielong> findAllRequest();
    Jielong findRequestById(long jielongId);
    void removeRequestById(long id) throws ExecutionException, InterruptedException;
    void updateRequest(Jielong jielong) throws ExecutionException, InterruptedException;

}
