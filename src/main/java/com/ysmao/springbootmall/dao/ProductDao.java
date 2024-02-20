package com.ysmao.springbootmall.dao;

import com.ysmao.springbootmall.dto.ProductRequest;
import com.ysmao.springbootmall.pojo.Product;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductDao {

    Product getProductId(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
