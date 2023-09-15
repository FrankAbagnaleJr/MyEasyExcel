package com.kyrie.service.impl;

import com.alibaba.excel.EasyExcel;
import com.kyrie.listener.ExcelReadListener;
import com.kyrie.pojo.ExcelExportQueryWapperDTO;
import com.kyrie.pojo.Product;
import com.kyrie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ExcelReadListener excelReadListener;

    /**
     * 读excel并存到数据量
     *
     * @param multipartFile
     */
    @Override
    public void readExcelAndSave(MultipartFile multipartFile) {
        try {
            //得到读工作簿对象.工作簿对象.读
            EasyExcel.read(multipartFile.getInputStream(), Product.class, excelReadListener).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询出符合条件的产品，封装成List集合，导出
     *
     * @param response 响应
     */
    @Override
    public void exportExcel(HttpServletResponse response, ExcelExportQueryWapperDTO dto) {

        try {
            response.setContentType("application/vnd.ms-excle");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("测试导出产品", "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName + ".xlsx");

            ServletOutputStream outputStream = response.getOutputStream();

            //根据dto规则筛选查询出符合条件的数据，转成List<Product>集合
            List<Product> products = queryProduct(dto);

            //导出
            EasyExcel.write(outputStream, Product.class).sheet().doWrite(products);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 根据前端的查询条件查询出对象，封装到list中
     *
     * @param dto
     * @return
     */
    private List<Product> queryProduct(ExcelExportQueryWapperDTO dto) {
        List<Product> products = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Product product1 = new Product("水果架", "五点" + i, "描述" + i, "B000" + i, "SKU" + i, "DE", new Date());
            products.add(product1);
        }
        return products;
    }
}
