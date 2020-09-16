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
    public ResponseEntity<String> addJielong(@RequestBody JielongObject jielongObject) {

        try {
            jielongService.addJielong(jielongObject);
            return new ResponseEntity<>("Jielong added successfully.", HttpStatus.CREATED);
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

    @GetMapping(value = "/{jielongId}")
    public ResponseEntity<JielongObject> getJielongsById(@PathVariable long jielongId) {

        try {
            JielongObject resultBody = jielongService.findJielongById(jielongId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<String> updateJielong(@RequestBody JielongObject jielongObject) {

        try {
            jielongService.updateJielong(jielongObject);
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
