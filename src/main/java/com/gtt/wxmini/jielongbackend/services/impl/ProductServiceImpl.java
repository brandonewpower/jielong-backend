package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.Product;
import com.gtt.wxmini.jielongbackend.repositories.ProductRepository;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product findProductById(long productId) {

        return productRepository.findById(productId).get();
    }

    @Override
    public void removeProductById(long id) throws ExecutionException, InterruptedException {

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProductByJielongId(long jielongId) {
        return productRepository.findAllByJielongId(jielongId);
    }

}
