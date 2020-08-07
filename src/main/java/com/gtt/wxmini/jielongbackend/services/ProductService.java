package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Product;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ProductService {

    public void addProduct(Product product) throws ExecutionException, InterruptedException;
    public void removeProduct (Product product) throws ExecutionException, InterruptedException;
    public List<Product> findAllByProductName(String productName);
    public Iterable<Product> findAllByProductId(long productId);
    public List<Product> findAllByProductPrice(double productPrice);
    public void removeAllByProductName(String productName) throws ExecutionException, InterruptedException;
    public void removeAllByProductId(long id) throws ExecutionException, InterruptedException;
}
