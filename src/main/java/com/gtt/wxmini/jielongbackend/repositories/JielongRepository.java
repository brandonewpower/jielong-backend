package com.gtt.wxmini.jielongbackend.repositories;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JielongRepository extends CrudRepository<Jielong, Long> {

}
