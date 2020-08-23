package com.gtt.wxmini.jielongbackend.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryId;
    private long jielongId;
    private ServiceMethod serviceMethod;
    private String address;
    private Date date;
}
