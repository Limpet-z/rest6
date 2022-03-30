package com.main.rest6.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "binance_account")
@Data
public class BinanceAccount implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "users_id")
    private long usersId;

    @Column(name = "public_key")
    private String public_key;

    @Column(name = "secret")
    private String secret;

    @Column(name = "binance_email")
    private String binance_email;

}