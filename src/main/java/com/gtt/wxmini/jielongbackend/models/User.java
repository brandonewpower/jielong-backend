package com.gtt.wxmini.jielongbackend.models;

import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private long jielongId;
    private int orderNumber;
    private String feedback;
    private String status;
}
