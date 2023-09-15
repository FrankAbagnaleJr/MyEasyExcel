package com.kyrie.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kyrie.pojo.Product;
import com.kyrie.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Slf4j
public class ExcelReadListener extends AnalysisEventListener<Product> {

    @Autowired
    private ProductService productService;
    @Override
    public void invoke(Product product, AnalysisContext analysisContext) {
        log.info("用户已存储到数据库");
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("用户添加完成");
    }
}
