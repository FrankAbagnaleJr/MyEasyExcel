package com.kyrie.excelListener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kyrie.pojo.Product;

public class Listener extends AnalysisEventListener<Product> {
    @Override
    public void invoke(Product product, AnalysisContext analysisContext) {
        System.out.println("productor:"+ product);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("完成");
    }
}
