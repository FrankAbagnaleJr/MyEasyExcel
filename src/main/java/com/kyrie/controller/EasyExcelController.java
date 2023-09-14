package com.kyrie.controller;

import com.kyrie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EasyExcelController {

    @Autowired
    private ProductService productService;
    @GetMapping("/read")
    public void readExcel(){

    }
}
