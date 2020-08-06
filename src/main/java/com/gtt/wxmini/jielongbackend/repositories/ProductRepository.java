package com.gtt.wxmini.jielongbackend.repositories;

import com.gtt.wxmini.jielongbackend.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllByProductName(String productName);
    List<Product> findAllByProductPrice(double productPrice);
}
