package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class JielongController {

    @Autowired
    private JielongService jielongService;

    //addRequest
    @PostMapping(value = "")
    public ResponseEntity<String> addRequest(@RequestBody Jielong jielong) {

        try {
            jielongService.addRequest(jielong);
            return new ResponseEntity<>("Request added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //removeRequestById
    @DeleteMapping(value = "")
    public ResponseEntity<String> removeRequestById(@PathVariable long requestId) {

        try {
            jielongService.removeRequestById(requestId);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //findRequestById
    @GetMapping(value = "/{requestId}")
    public ResponseEntity<Optional<Jielong>> getAllRequestById(@PathVariable long requestId) {

        try {
            Optional<Jielong> resultBody = jielongService.findRequestById(requestId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
