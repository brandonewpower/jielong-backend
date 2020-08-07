package com.gtt.wxmini.jielongbackend.controllers;

import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "")
public class ProductController {

    @Autowired
    private ProductService productService;

    //addProduct
    @PostMapping(value = "")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        try {
            productService.addProduct(product);
            return new ResponseEntity<>("Product added successfully.", HttpStatus.CREATED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //removeProductById
    @DeleteMapping(value = "")
    public ResponseEntity<String> removeProductById(@PathVariable long productId) {

        try {
            productService.removeProductById(productId);
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (InterruptedException | ExecutionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //findProductById
    @GetMapping(value = "/{productId}")
    public ResponseEntity<Optional<Product>> getAllProductsById(@PathVariable long productId) {

        try {
            Optional<Product> resultBody = productService.findProductById(productId);
            return new ResponseEntity<>(resultBody, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //removeAllProduct
    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<String> removeAllProductById(@PathVariable long productId) {

        try {
            productService.removeAllProducts();
            return new ResponseEntity<>("Product deleted successfully.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
