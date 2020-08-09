package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.models.Product;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface JielongService {

    public void addRequest(Jielong jielong) throws ExecutionException, InterruptedException;
    public void updateRequest(long id) throws ExecutionException, InterruptedException;
    public Optional<Jielong> findRequestById(long jielongId) throws ExecutionException, InterruptedException;
    public void removeRequestById(long id) throws ExecutionException, InterruptedException;

    //optional findAll, updateRequest, removeAll, addFavourite

}
