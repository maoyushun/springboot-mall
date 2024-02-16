package com.ysmao.springbootmall.service.impl;

import com.ysmao.springbootmall.dao.ProductDao;
import com.ysmao.springbootmall.pojo.Product;
import com.ysmao.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductId(Integer productId) {

        return productDao.getProductId(productId);
    }
}
