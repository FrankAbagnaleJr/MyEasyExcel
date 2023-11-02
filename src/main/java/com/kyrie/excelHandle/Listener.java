package com.kyrie.excelHandle;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Auther: 冀金梁
 * @Date: 2023/11/1 16:22 周三
 * @Project_Name: demo
 * @Version: 1.0
 * @description TODO
 */
public class Listener extends AnalysisEventListener<Map<String,String>> {
    @Override
    public void invoke(Map<String,String> map, AnalysisContext analysisContext) {
        String s = map.get(0);
        //截取（ 和 ），
        String substring = s.substring(1, s.length() - 2);
        //按照逗号切割
        String[] split = substring.split(",");
        //创建一个对象准备封装
        Pojo pojo = new Pojo();
        //得到类加载器准备用反射赋值
        Class c = pojo.getClass();
        //得到对象的全部属性
        Field[] declaredFields = c.getDeclaredFields();



//        String endstr = "";
        //循环每个字符串
        int k = 0;
        for (int i = 0; i < split.length; i++) {

            String str = split[i];
            //去掉前后空格
            if (str.startsWith(" ")) {
                str = StrUtil.trim(str);
            }
            //判断开头和结尾是否是``，如果是则截取
            if (str.startsWith("'") && str.endsWith("'") && str.length() > 2) {
                //得到最终的字符串
                str = str.substring(1, str.length() - 1);
            }
            //判断如果是空的那字符串就是空
            if (str.startsWith("'") && str.endsWith("'") && str.length() == 2) {
                str = "";
            }
            //如果是单引号开头，却不是单引号结束，那说明拆错了，去拼接下一个字符串，用逗号连接上
            if (str.startsWith("'") && !str.endsWith("'")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                int j = i + 1;
                //如果不是单引号结尾，那么就拼上
                while (true) {
                    sb.append(",").append(split[j]);
//                    endstr = str + "," + split[j];
                    //如果是单引号结尾，跳出循环
                    if (split[j].endsWith("'")) break;
                    j++;
                }
                //下次循环从这次开始
                i = j ;
                //截取前后引号
                str = sb.substring(1, sb.length() - 1);;
            }

            //得到set方法名
            String setMethod = "set" + Utils.handleStr(declaredFields[k].getName());

            try {
                //得到set方法
                Method method = Pojo.class.getMethod(setMethod, declaredFields[k].getType());
                //判断如果是时间，那么转化
                if (Objects.equals(declaredFields[k].getType(), LocalDateTime.now().getClass())) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime parse = LocalDateTime.parse(str, dateTimeFormatter);
                    method.invoke(pojo, parse);
                    continue;
                }
                //调用set方法赋值
                method.invoke(pojo, str);
                //每次把临时字符串清空
//                endstr = "";
                k++;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        //存入全局list中
        Main.list.add(pojo);
        System.out.println("处理完1行");
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("已经读取完成");
    }
}
