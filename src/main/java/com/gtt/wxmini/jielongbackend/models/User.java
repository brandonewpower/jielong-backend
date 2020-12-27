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
    private String nickName;
    private int openId;
    private long jielongId;
    private Status status;
    private int orderNumber;
    private String feedback;
}
