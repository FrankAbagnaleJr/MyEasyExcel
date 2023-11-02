package com.kyrie.excelHandle;

/**
 * @Auther: 冀金梁
 * @Date: 2023/11/1 17:10 周三
 * @Project_Name: demo
 * @Version: 1.0
 * @description TODO
 */
public class Utils {
    public static String handleStr(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
