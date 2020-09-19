package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Delivery;
import com.gtt.wxmini.jielongbackend.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping(value = "")
    public ResponseEntity<String> addDelivery(@RequestBody Delivery Delivery) {

        try {
            deliveryService.addDelivery(Delivery);
            return new ResponseEntity<>("Delivery added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{deliveryId}")
    public ResponseEntity<Delivery> getDeliverysByDeliveryId(@PathVariable long deliveryId) {

        try {
            Delivery resultBody = deliveryService.findDeliveryByDeliveryId(deliveryId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<String> updateDelivery(@RequestBody Delivery Delivery) {

        try {
            deliveryService.updateDelivery(Delivery);
            return new ResponseEntity<>("Delivery updated successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{deliveryId}")
    public ResponseEntity<String> removeDeliveryById(@PathVariable long deliveryId) {

        try {
            deliveryService.removeDeliveryById(deliveryId);
            return new ResponseEntity<>("Delivery deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
