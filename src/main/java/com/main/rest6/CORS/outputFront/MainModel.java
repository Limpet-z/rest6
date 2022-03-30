package com.main.rest6.CORS.outputFront;

import com.main.rest6.model.Role;

import java.util.List;
import java.util.Locale;

public class MainModel {
    private long ID;
    private String email;
    private String name;
    private Locale ip;
    private String country;
    private List<Role> roles;
    private long timestamp;
    private String subscriber;
    private int subscribeExpiration;

    private List<CryptoMarket> cryptoMarket;
}

class CryptoMarket {
    private String assets;
    private String exchangeName;
    private String ticker;
}
