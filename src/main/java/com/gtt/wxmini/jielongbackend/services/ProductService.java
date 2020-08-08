package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Product;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface ProductService {

    public void addProduct(Product product) throws ExecutionException, InterruptedException;
    public Optional<Product> findProductById(long productId);
    public void removeProductById(long id) throws ExecutionException, InterruptedException;

    //addProduct
    //removeProductById
    //getProductById

}
