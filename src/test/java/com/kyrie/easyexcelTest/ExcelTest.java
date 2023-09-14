package com.kyrie.easyexcelTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.kyrie.excelListener.Listener;
import com.kyrie.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class ExcelTest {

    @Test
    public void read(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\product.xlsx");
        List<Object> list = EasyExcel.read(file).sheet(0).doReadSync();

        for (Object o : list) {
            log.info("item:{}",o);
        }
    }

    @Test
    public void read2(){
        InputStream inputStream = ExcelTest.class.getClassLoader().getResourceAsStream("product.xlsx");
        List<Object> list = EasyExcel.read(inputStream).sheet(0).doReadSync();
        for (Object o : list) {
            log.info("item:{}",o);
        }
    }

    @Test
    public void read3(){
        //创建文件
        File file = new File("C:\\Users\\Administrator\\Desktop\\product.xlsx");
        //创建监听器
        Listener listener = new Listener();
        //得到工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read(file, Product.class, listener);
        //获得工作表对象
        ExcelReaderSheetBuilder sheet = workBook.sheet(0);
        //得到工作表内容


    }

}
