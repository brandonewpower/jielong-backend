package com.gtt.wxmini.jielongbackend.services;

import com.gtt.wxmini.jielongbackend.models.Product;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ProductService {

    void addProduct(Product product) throws ExecutionException, InterruptedException;
    Product findProductById(long productId);
    void removeProductById(long id) throws ExecutionException, InterruptedException;
    List<Product> findAllProductByJielongId(long jielongId);

}
