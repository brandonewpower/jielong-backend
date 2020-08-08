package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.repositories.JielongRepository;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class JielongServiceImpl implements JielongService {

    @Autowired
    private JielongRepository jielongRepository;

    //add and update
    @Override
    public void addRequest(Jielong jielong) throws ExecutionException, InterruptedException {

        jielongRepository.save(jielong);
    }

    //findAll
    public Iterable<Jielong> findAllRequest() {

        return jielongRepository.findAll();
    }

    @Override
    public Optional<Jielong> findRequestById(long jielongId) {

        return jielongRepository.findById(jielongId);
    }

    @Override
    public void removeRequestById(long id) throws ExecutionException, InterruptedException {
        jielongRepository.deleteById(id);
    }
}
