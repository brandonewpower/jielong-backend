package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
    public ResponseEntity<String> removeProduct(@RequestBody Product product) {

        try {
            productService.removeProduct(product);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{productName}")
    public ResponseEntity<Collection<Product>> getAllProductsByName(@PathVariable String productName) {

        try {
            Collection<Product> resultBody = productService.findAllByProductName(productName);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Iterable<Product>> getAllProductsById(@PathVariable long productId) {

        try {
            Iterable<Product> resultBody = productService.findAllByProductId(productId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{productPrice}")
    public ResponseEntity<Collection<Product>> getAllProductsByPrice(@PathVariable double productPrice) {

        try {
            Collection<Product> resultBody = productService.findAllByProductPrice(productPrice);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{productName}")
    public ResponseEntity<String> removeAllProductByName(@PathVariable String productName) {

        try {
            productService.removeAllByProductName(productName);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<String> removeAllProductById(@PathVariable long productId) {

        try {
            productService.removeAllByProductId(productId);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
