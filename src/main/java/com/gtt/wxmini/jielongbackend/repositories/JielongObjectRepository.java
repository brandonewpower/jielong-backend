package com.gtt.wxmini.jielongbackend.repositories;

import com.gtt.wxmini.jielongbackend.models.JielongObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JielongObjectRepository extends CrudRepository<JielongObject, Long> {

    List<JielongObject> findAll();
}
