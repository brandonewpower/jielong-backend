package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.User;
import com.gtt.wxmini.jielongbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        try {
            userService.addUser(user);
            return new ResponseEntity<>("User added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable long Id) {

        try {
            User resultBody = userService.findUserById(Id);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable long userId) {

        try {
            User resultBody = userService.findUserByUserId(userId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{jielongId}")
    public ResponseEntity<User> getUserByJielongId(@PathVariable long jielongId) {

        try {
            User resultBody = userService.findUserByJielongId(jielongId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity<String> removeUserById(@PathVariable long Id) {

        try {
            userService.removeUserById(Id);
            return new ResponseEntity<>("User deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<String> updateUser(@RequestBody User user) {

        try {
            userService.addUser(user);
            return new ResponseEntity<>("User updated successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
