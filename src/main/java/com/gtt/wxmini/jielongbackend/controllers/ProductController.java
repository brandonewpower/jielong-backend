package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        try {
            productService.addProduct(product);
            return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "")
    public ResponseEntity<String> removeProductById(@PathVariable long productId) {

        try {
            productService.removeProductById(productId);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) {

        try {
            Product resultBody = productService.findProductById(productId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
