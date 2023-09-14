大概步骤就是先读取文件，获取工作薄对象。从本地file或者流都可以
创建监听器，每读一行都会用到监听器，调用invoke方法，再该方法中操作读取到的数据


第一步：引入依赖

    <!--   Easy Excel  排除它自带的slf4j日志版本    -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>easyexcel</artifactId>
        <version>3.1.4</version>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-api</artifactId>
                </exclusion>
            </exclusions>
    </dependency>

第二步：创建监听器
    
    写个类继承AnalysisEventListener<实体类>  每读取一行都会调用该方法
        重写invoke方法（每读一行都会调用该方法）
        重新doAfterAllAnalysed方法（全部读取完后调用该方法）

读取文件，获取工作簿对象

    从流中读取
    EasyExcel.read( new InputStream("c:/soft/1.xlsx"), 实体类.class, 监听器);
    从本地拿
    EasyExcel.read( new File("c:/soft/1.xlsx"), 实体类.class, 监听器);


    
