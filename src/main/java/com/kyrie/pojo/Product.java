package com.kyrie.pojo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ExcelIgnoreUnannotated
public class Product {
    @ExcelProperty("产品名字")
    private String name;
    private String fivePoint;
    private String description;
    private String asin;
    private String sku;
    private String county;
    private Date createDate;
}
