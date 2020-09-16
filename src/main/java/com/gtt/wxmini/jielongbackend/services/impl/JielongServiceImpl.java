package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.*;
import com.gtt.wxmini.jielongbackend.repositories.JielongObjectRepository;
import com.gtt.wxmini.jielongbackend.repositories.JielongRepository;
import com.gtt.wxmini.jielongbackend.services.DeliveryService;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import com.gtt.wxmini.jielongbackend.services.ProductService;
import com.gtt.wxmini.jielongbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class JielongServiceImpl implements JielongService {

    @Autowired
    private JielongRepository jielongRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private UserService userService;

    @Autowired
    private JielongObjectRepository jielongObjectRepository;

    @Override
    public void addJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException {

        Jielong jielong = new Jielong();
        setupJielong(jielong, jielongObject);
        jielongRepository.save(jielong);

        List<Delivery> deliveryList = jielongObject.getDeliveryList();
        for(Delivery delivery : deliveryList) {
            deliveryService.addDelivery(delivery);
        }

        List<Product> productList = jielongObject.getProductList();
        for(Product product : productList) {
            productService.addProduct(product);
        }

        List<User> userList = jielongObject.getUserList();
        for(User user : userList) {
            userService.addUser(user);
        }
    }

    @Override
    public List<JielongObject> findAllJielong() {

        List<JielongObject> jielongObjectList = new ArrayList<>();

        Iterable<Jielong> allJielong = jielongRepository.findAll();

        for(Jielong jielong : allJielong) {
            JielongObject jielongObject;
            long jielongId = jielong.getJielongId();
            jielongObject = findJielongById(jielongId);
            jielongObjectList.add(jielongObject);
        }
        return jielongObjectList;
    }

    @Override
    public JielongObject findJielongById(long jielongId) {

        List<User> userList = userService.findAllUserByJielongId(jielongId);
        List<Product> productList = productService.findAllProductByJielongId(jielongId);
        List<Delivery> deliveryList = deliveryService.findAllDeliveryByJielongId(jielongId);
        Jielong jielong = jielongRepository.findById(jielongId).get();

        JielongObject jielongObject = new JielongObject();
        jielongObject.setJielongId(jielong.getJielongId());
        jielongObject.setStatementTime(jielong.getStatementTime());
        jielongObject.setOrderQuantity(jielong.getOrderQuantity());
        jielongObject.setOrderPrice(jielong.getOrderPrice());
        jielongObject.setNeedGuestName(jielong.isNeedGuestName());
        jielongObject.setNeedGuestPhone(jielong.isNeedGuestPhone());

        jielongObject.setUserList(userList);
        jielongObject.setProductList(productList);
        jielongObject.setDeliveryList(deliveryList);

        return jielongObject;
    }

    @Override
    public void removeJielongById(long id) throws ExecutionException, InterruptedException {

        JielongObject jielongObject = jielongObjectRepository.findById(id).get();

        List<Product> productList = jielongObject.getProductList();
        for(Product product : productList) {
            productService.removeProductById(product.getProductId());
        }

        List<Delivery> deliveryList = jielongObject.getDeliveryList();
        for(Delivery delivery : deliveryList) {
            deliveryService.removeDeliveryById(delivery.getDeliveryId());
        }

        List<User> userList = jielongObject.getUserList();
        for(User user : userList) {
            userService.removeUserById(user.getUserId());
        }

        jielongObjectRepository.deleteById(id);
        jielongRepository.deleteById(id);
    }

    @Override
    public void updateJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException {

        long jielongId = jielongObject.getJielongId();
        Jielong jielong = jielongRepository.findById(jielongId).get();
        setupJielong(jielong, jielongObject);
        jielongRepository.save(jielong);
    }

    void setupJielong(Jielong jielong, JielongObject jielongObject) {

        jielong.setJielongId(jielongObject.getJielongId());
        jielong.setStatementTime(jielongObject.getStatementTime());
        jielong.setOrderQuantity(jielongObject.getOrderQuantity());
        jielong.setOrderPrice(jielongObject.getOrderPrice());
        jielong.setNeedGuestName(jielongObject.isNeedGuestName());
        jielong.setNeedGuestPhone(jielongObject.isNeedGuestPhone());
    }
}
