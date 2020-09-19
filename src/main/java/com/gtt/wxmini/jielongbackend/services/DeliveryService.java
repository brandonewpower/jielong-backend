package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Delivery;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DeliveryService {

    void addDelivery(Delivery delivery) throws ExecutionException, InterruptedException;
    Delivery findDeliveryByDeliveryId(long id);
    void updateDelivery(Delivery delivery) throws ExecutionException, InterruptedException;
    void removeDeliveryById(long id) throws ExecutionException, InterruptedException;
    List<Delivery> findAllDeliveryByJielongId(long id);
}
