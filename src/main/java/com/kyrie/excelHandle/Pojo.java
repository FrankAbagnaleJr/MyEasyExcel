package com.kyrie.excelHandle;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Auther: 冀金梁
 * @Date: 2023/11/1 16:50 周三
 * @Project_Name: demo
 * @Version: 1.0
 * @description TODO
 */
@Data
public class Pojo {
  String id;
  String name;
  String fgroup;
  String priority;
  String description;
  String cron;
  String server;
  String bean;
  String method;
  String parameter;
  String path;
  String isdelete;
  LocalDateTime createdate;
}
