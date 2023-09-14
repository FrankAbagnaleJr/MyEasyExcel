package com.kyrie.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private String name;
    private String fivePoint;
    private String description;
    private String asin;
    private String sku;
    private Date createDate;
}
