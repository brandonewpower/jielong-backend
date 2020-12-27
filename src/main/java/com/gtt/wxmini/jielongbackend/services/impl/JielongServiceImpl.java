package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.*;
import com.gtt.wxmini.jielongbackend.repositories.JielongRepository;
import com.gtt.wxmini.jielongbackend.services.JielongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class JielongServiceImpl implements JielongService {

    @Autowired
    private JielongRepository jielongRepository;

    @Override
    public long addJielong(Jielong jielong) throws ExecutionException, InterruptedException{

        return jielongRepository.save(jielong).getJielongId();
    }

    @Override
    public List<Jielong> findAllJielong(){

        List<Jielong> jielongList = new ArrayList<>();

        Iterable<Jielong> allJielong = jielongRepository.findAll();

        for(Jielong jielong : allJielong) {
            jielongList.add(jielong);
        }
        return jielongList;
    }

    @Override
    public Jielong findJielongById(long jielongId) {
        return jielongRepository.findById(jielongId).get();
    }

    @Override
    public void removeJielongById(long id) throws ExecutionException, InterruptedException {
        jielongRepository.deleteById(id);
    }

    @Override
    public void updateJielong(Jielong jielong) throws ExecutionException, InterruptedException {
        jielongRepository.save(jielong);
    }


//    @Override
//    public void addJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException {
//
//        Jielong jielong = new Jielong();
//        setupJielong(jielong, jielongObject);
//        jielongRepository.save(jielong);
//
//        List<Delivery> deliveryList = jielongObject.getDeliveryList();
//        for(Delivery delivery : deliveryList) {
//            deliveryService.addDelivery(delivery);
//        }
//
//        List<Product> productList = jielongObject.getProductList();
//        for(Product product : productList) {
//            productService.addProduct(product);
//        }
//
//        List<User> userList = jielongObject.getUserList();
//        for(User user : userList) {
//            userService.addUser(user);
//        }
//    }
//
//    @Override
//    public List<JielongObject> findAllJielong() {
//
//        List<JielongObject> jielongObjectList = new ArrayList<>();
//
//        Iterable<Jielong> allJielong = jielongRepository.findAll();
//
//        for(Jielong jielong : allJielong) {
//            JielongObject jielongObject;
//            long jielongId = jielong.getJielongId();
//            jielongObject = findJielongById(jielongId);
//            jielongObjectList.add(jielongObject);
//        }
//        return jielongObjectList;
//    }
//
//    @Override
//    public JielongObject findJielongById(long jielongId) {
//
//        List<User> userList = userService.findAllUserByJielongId(jielongId);
//        List<Product> productList = productService.findAllProductByJielongId(jielongId);
//        List<Delivery> deliveryList = deliveryService.findAllDeliveryByJielongId(jielongId);
//        Jielong jielong = jielongRepository.findById(jielongId).get();
//
//        JielongObject jielongObject = new JielongObject();
//        setupJielong(jielong, jielongObject);
////        jielongObject.setJielongId(jielong.getJielongId());
////        jielongObject.setStatementTime(jielong.getStatementTime());
////        jielongObject.setOrderQuantity(jielong.getOrderQuantity());
////        jielongObject.setOrderPrice(jielong.getOrderPrice());
////        jielongObject.setNeedGuestName(jielong.isNeedGuestName());
////        jielongObject.setNeedGuestPhone(jielong.isNeedGuestPhone());
////        jielongObject.setDescription(jielong.getDescription());
//
//        jielongObject.setUserList(userList);
//        jielongObject.setProductList(productList);
//        jielongObject.setDeliveryList(deliveryList);
//
//        return jielongObject;
//    }
//
//    @Override
//    public void removeJielongById(long id) throws ExecutionException, InterruptedException {
//
//        JielongObject jielongObject = findJielongById(id);
//        List<Product> productList = jielongObject.getProductList();
//        for(Product product : productList) {
//            productService.removeProductById(product.getProductId());
//        }
//
//        List<Delivery> deliveryList = jielongObject.getDeliveryList();
//        for(Delivery delivery : deliveryList) {
//            deliveryService.removeDeliveryById(delivery.getDeliveryId());
//        }
//
//        List<User> userList = jielongObject.getUserList();
//        for(User user : userList) {
//            userService.removeUserById(user.getUserId());
//        }
//
//        jielongRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateJielong(JielongObject jielongObject) throws ExecutionException, InterruptedException {
//
//        long jielongId = jielongObject.getJielongId();
//        Jielong jielong = jielongRepository.findById(jielongId).get();
//        setupJielong(jielong, jielongObject);
//        jielongRepository.save(jielong);
//    }
//
//    private void setupJielong(Jielong jielong, JielongObject jielongObject) {
//
//        jielong.setJielongId(jielongObject.getJielongId());
//        jielong.setStatementTime(jielongObject.getStatementTime());
//        jielong.setOrderQuantity(jielongObject.getOrderQuantity());
//        jielong.setOrderPrice(jielongObject.getOrderPrice());
//        jielong.setNeedGuestName(jielongObject.isNeedGuestName());
//        jielong.setNeedGuestPhone(jielongObject.isNeedGuestPhone());
//        jielong.setDescription(jielongObject.getDescription());
//    }
}
