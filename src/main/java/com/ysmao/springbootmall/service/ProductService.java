package com.ysmao.springbootmall.service;

import com.ysmao.springbootmall.dto.ProductRequest;
import com.ysmao.springbootmall.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductId(Integer productId);
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
