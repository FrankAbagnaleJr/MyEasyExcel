package com.kyrie.excelHandle;

import com.alibaba.excel.EasyExcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 冀金梁
 * @Date: 2023/11/1 16:18 周三
 * @Project_Name: demo
 * @Version: 1.0
 * @description TODO
 */
public class Main {
    static List<Pojo> list = new ArrayList<>();

    public static void main(String[] args) {

        //整理的文件
        File sourcrFile = new File("C:\\Users\\Administrator\\Desktop\\1.xlsx");
        //输出的文件
        File resultFile = new File("C:\\Users\\Administrator\\Desktop\\2.xlsx");

        Listener listener = new Listener();

        try {
            //源文件的文件输入流
            FileInputStream fis = new FileInputStream(sourcrFile);
            //读文件,读取后把信息封装成对象保存再list中
            EasyExcel.read(fis, listener).sheet().doRead();

            //目标文件的输出流
            FileOutputStream fos = new FileOutputStream(resultFile);
            //写出文件
            EasyExcel.write(fos, Pojo.class).sheet().doWrite(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
