package com.kyrie.controller;

import com.kyrie.pojo.ExcelExportQueryWapperDTO;
import com.kyrie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/product")
public class EasyExcelController {

    @Autowired
    private ProductService productService;
    @PostMapping("/importExcel")
    public void importExcel(MultipartFile upLoadExcel){
        productService.readExcelAndSave(upLoadExcel);
    }

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response,ExcelExportQueryWapperDTO dto){
        productService.exportExcel(response,dto);
    }
}
