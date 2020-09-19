package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.Delivery;
import com.gtt.wxmini.jielongbackend.repositories.DeliveryRepository;
import com.gtt.wxmini.jielongbackend.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void addDelivery(Delivery delivery) throws ExecutionException, InterruptedException {

        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery findDeliveryByDeliveryId(long id) {

        return deliveryRepository.findById(id).get();
    }

    @Override
    public void updateDelivery(Delivery delivery) throws ExecutionException, InterruptedException {

        deliveryRepository.save(delivery);
    }

    @Override
    public void removeDeliveryById(long id) throws ExecutionException, InterruptedException {

        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> findAllDeliveryByJielongId(long id) {

        return deliveryRepository.findAllByJielongId(id);
    }
}
