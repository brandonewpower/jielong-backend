package com.gtt.wxmini.jielongbackend.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jielong_table")
public class Jielong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UUID;
    private Date statementTime;
    private int orderQuantity;
    private double orderPrice;
    private long deliveryId;
    private String address;
    private Date serviceTime;
    private boolean needGuestName;
    private boolean needGuestPhone;

}
