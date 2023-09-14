package com.kyrie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kyrie.mapper.ProductMapper;
import com.kyrie.pojo.Product;
import com.kyrie.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
