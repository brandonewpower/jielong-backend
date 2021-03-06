package com.gtt.wxmini.jielongbackend.models;

import java.sql.Date;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JielongObject {

    private long jielongId;
    private Date statementTime;
    private int orderQuantity;
    private double orderPrice;
    private boolean needGuestName;
    private boolean needGuestPhone;
    private String description;

    private List<Product> productList;
    private List<Delivery> deliveryList;
    private List<User> userList;

}
