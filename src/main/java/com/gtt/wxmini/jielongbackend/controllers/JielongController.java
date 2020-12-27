package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Jielong;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/jielongs")
public class JielongController {

    @Autowired
    private JielongService jielongService;

    @PostMapping(value = "")
    public ResponseEntity<Long> addJielong(@RequestBody Jielong jielong) {

        try {
            long resultBody = jielongService.addJielong(jielong);
            return new ResponseEntity<>(resultBody, HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Jielong>> getAllJielongs() {

        try {
            List<Jielong> resultBody = jielongService.findAllJielong();
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{jielongId}")
    public ResponseEntity<Jielong> getJielongsById(@PathVariable long jielongId) {

        try {
            Jielong resultBody = jielongService.findJielongById(jielongId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<String> updateJielong(@RequestBody Jielong jielong) {

        try {
            jielongService.updateJielong(jielong);
            return new ResponseEntity<>("Jielong updated successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{jielongId}")
    public ResponseEntity<String> removeJielongById(@PathVariable long jielongId) {

        try {
            jielongService.removeJielongById(jielongId);
            return new ResponseEntity<>("Jielong deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
