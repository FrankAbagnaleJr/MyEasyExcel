package com.kyrie.service;


import com.kyrie.pojo.ExcelExportQueryWapperDTO;
import com.kyrie.pojo.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


public interface ProductService {

    /**
     * 读excel文件并存到数据库
     * @param multipartFile
     */
    void readExcelAndSave(MultipartFile multipartFile);

    void exportExcel(HttpServletResponse response,ExcelExportQueryWapperDTO dto);
}
