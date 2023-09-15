package com.kyrie.pojo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ExcelIgnoreUnannotated
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @ExcelProperty("产品名字")
    private String name;
    @ExcelProperty("五点")
    private String fivePoint;
    @ExcelProperty("描述")
    private String description;
    @ExcelProperty("ASIN")
    private String asin;
    @ExcelProperty("SKU")
    private String sku;
    @ExcelProperty("国家")
    private String county;
    @ExcelProperty("创建时间")
    private Date createDate;
}
