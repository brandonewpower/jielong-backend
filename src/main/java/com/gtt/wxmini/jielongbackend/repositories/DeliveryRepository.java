package com.gtt.wxmini.jielongbackend.repositories;

import com.gtt.wxmini.jielongbackend.models.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    List<Delivery> findAllByJielongId(long jielongId);
}
