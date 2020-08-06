package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.repositories.ProductRepository;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) throws ExecutionException, InterruptedException {

        productRepository.save(product);
    }

    @Override
    public void removeProduct(Product product) throws ExecutionException, InterruptedException {

        productRepository.delete(product);
    }

    @Override
    public List<Product> findAllByProductName(String productName) {

        return productRepository.findAllByProductName(productName);
    }

    //Id problem
    @Override
    public Iterable<Product> findAllByProductId(long productId) {

        return productRepository.findAllById(Collections.singleton(productId));
    }

    @Override
    public List<Product> findAllByProductPrice(double productPrice) {

        return productRepository.findAllByProductPrice(productPrice);
    }

    @Override
    public void removeAllByProductName(String productName) throws ExecutionException, InterruptedException {

        productRepository.deleteAll(this.findAllByProductName(productName));
    }

    @Override
    public void removeAllByProductId(long id) throws ExecutionException, InterruptedException {

        productRepository.deleteAll(this.findAllByProductId(id));
    }

    //Only findAll

}
