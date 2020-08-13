package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class JielongController {

    @Autowired
    private JielongService jielongService;

    @PostMapping(value = "")
    public ResponseEntity<String> addRequest(@RequestBody Jielong jielong) {

        try {
            jielongService.addRequest(jielong);
            return new ResponseEntity<>("Request added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{requestId}")
    public ResponseEntity<String> removeRequestById(@PathVariable long requestId) {

        try {
            jielongService.removeRequestById(requestId);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{requestId}")
    public ResponseEntity<Jielong> getRequestsById(@PathVariable long requestId) {

        try {
            Jielong resultBody = jielongService.findRequestById(requestId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<String> updateRequest(@RequestBody Jielong jielong) {

        try {
            jielongService.updateRequest(jielong);
            return new ResponseEntity<>("Request updated successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<Jielong>> getAllRequests() {

        try {
            Iterable<Jielong> resultBody = jielongService.findAllRequest();
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
