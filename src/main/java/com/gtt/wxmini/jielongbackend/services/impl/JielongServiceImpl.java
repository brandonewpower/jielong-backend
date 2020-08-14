package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.repositories.JielongRepository;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class JielongServiceImpl implements JielongService {

    @Autowired
    private JielongRepository jielongRepository;

    @Override
    public void addRequest(Jielong jielong) throws ExecutionException, InterruptedException {

        jielongRepository.save(jielong);
    }

    @Override
    public Iterable<Jielong> findAllRequest() {

        return jielongRepository.findAll();
    }

    @Override
    public Jielong findRequestById(long jielongId) {

        return jielongRepository.findById(jielongId).get();
    }

    @Override
    public void removeRequestById(long id) throws ExecutionException, InterruptedException {

        jielongRepository.deleteById(id);
    }

    @Override
    public void updateRequest(Jielong jielong) throws ExecutionException, InterruptedException {

        jielongRepository.save(jielong);
    }
}
