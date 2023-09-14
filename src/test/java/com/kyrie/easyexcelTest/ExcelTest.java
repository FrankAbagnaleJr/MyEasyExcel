package com.kyrie.easyexcelTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.kyrie.excelListener.Listener;
import com.kyrie.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
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
    public void read3() throws FileNotFoundException {
        //创建文件
        File file = new File("C:\\Users\\Administrator\\Desktop\\product.xlsx");
        InputStream inputStream = new FileInputStream(file);
        //创建监听器
        Listener listener = new Listener();
        //得到工作簿对象,这里用file和inputStream都可以
        ExcelReaderBuilder workBook = EasyExcel.read(inputStream, Product.class, listener);
        //获得工作表对象，0表示第一个工作表
        ExcelReaderSheetBuilder sheet = workBook.sheet(0);
        //读取工作表内容
        sheet.doRead();

    }
    @Test
    public void read4() {
        //创建输出的文件路径
        File file = new File("C:\\Users\\Administrator\\Desktop\\product.xlsx");
        //创建工作簿
        ExcelWriterBuilder writeWorkBook = EasyExcel.write(file, Product.class);
        //创建工作表对象
        ExcelWriterSheetBuilder sheet = writeWorkBook.sheet();
        //准备数据
        List<Product> list = new ArrayList<>();
        //写出
        sheet.doWrite(list);

    }
}
