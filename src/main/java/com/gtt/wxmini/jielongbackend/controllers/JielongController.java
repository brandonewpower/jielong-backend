package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.models.JielongObject;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class JielongController {

    @Autowired
    private JielongService jielongService;

    @PostMapping(value = "")
    public ResponseEntity<String> addJielong(@RequestBody Jielong jielong) {

        try {
            jielongService.addJielong(jielong);
            return new ResponseEntity<>("Jielong added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{JielongId}")
    public ResponseEntity<String> removeJielongById(@PathVariable long JielongId) {

        try {
            jielongService.removeJielongById(JielongId);
            return new ResponseEntity<>("Jielong deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{JielongId}")
    public ResponseEntity<JielongObject> getJielongsById(@PathVariable long JielongId) {

        try {
            JielongObject resultBody = jielongService.findJielongById(JielongId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<String> updateJielong(@RequestBody Jielong jielong) {

        try {
            jielongService.updateJielong(jielong);
            return new ResponseEntity<>("Jielong updated successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<List<JielongObject>> getAllJielongs() {

        try {
            List<JielongObject> resultBody = jielongService.findAllJielong();
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
