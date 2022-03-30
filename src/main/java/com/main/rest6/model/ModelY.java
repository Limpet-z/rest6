package com.main.rest6.model;

import java.util.List;

@lombok.Data
public class ModelY {
    private int code;
    private List<Data> data;

}

@lombok.Data
class Data {
    private String asset;
    private String totalBalance;


}
