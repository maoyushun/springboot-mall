package com.ysmao.springbootmall.service;

import com.ysmao.springbootmall.dto.ProductRequest;
import com.ysmao.springbootmall.pojo.Product;

public interface ProductService {

    Product getProductId(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
