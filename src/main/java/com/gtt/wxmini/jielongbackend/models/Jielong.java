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
    private long jielongId;
    private Date statementTime;
    private int orderQuantity;
    private double orderPrice;
    private boolean needGuestName;
    private boolean needGuestPhone;
    private String description;
    private long startersUserId;

}
