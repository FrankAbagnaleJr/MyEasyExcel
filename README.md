读

    大概步骤就是先读取文件，获取工作薄对象。从本地file或者流都可以
    创建监听器，每读一行都会用到listener监听器，调用invoke方法，再该方法中操作读取到的数据
写
    

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
        重写invoke方法（每读一行都会调用该方法） *可以读一行存一次数据库
        重新doAfterAllAnalysed方法（全部读取完后调用该方法） *可以读完一次性存数据库

读取文件

    从流中读取
    EasyExcel.read( new InputStream("c:/soft/1.xlsx"), 实体类.class, 监听器);
    从本地拿
    EasyExcel.read( new File("c:/soft/1.xlsx"), 实体类.class, 监听器);

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

写文件导出
    
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

        给实体类字上面加 @ExcelProperty("产品名字") 这样导出的标头就是中文，不然是实体类英文名
        如果不想把某个字段导出，比如id，那就不要加@ExcelProperty这个注解，并且在实体类上面加@@ExcelIgnoreUnannotated

    
