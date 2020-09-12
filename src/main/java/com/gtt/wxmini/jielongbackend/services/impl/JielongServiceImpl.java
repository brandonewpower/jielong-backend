package com.gtt.wxmini.jielongbackend.services.impl;

import com.gtt.wxmini.jielongbackend.models.*;
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

    @Override
    public void addJielong(Jielong jielong) throws ExecutionException, InterruptedException {

        jielongRepository.save(jielong);
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
        jielongObject.setAddress(jielong.getAddress());
        jielongObject.setServiceTime(jielong.getServiceTime());
        jielongObject.setNeedGuestName(jielong.isNeedGuestName());
        jielongObject.setNeedGuestPhone(jielong.isNeedGuestPhone());

        jielongObject.setUserList(userList);
        jielongObject.setProductList(productList);
        jielongObject.setDeliveryList(deliveryList);

        return jielongObject;
    }

    @Override
    public void removeJielongById(long id) throws ExecutionException, InterruptedException {

        jielongRepository.deleteById(id);
    }

    @Override
    public void updateJielong(Jielong jielong) throws ExecutionException, InterruptedException {

        jielongRepository.save(jielong);
    }
}
