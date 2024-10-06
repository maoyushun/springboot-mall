package com.ysmao.springbootmall.dao;

import com.ysmao.springbootmall.constant.ProductCategory;
import com.ysmao.springbootmall.dto.ProductQueryParams;
import com.ysmao.springbootmall.dto.ProductRequest;
import com.ysmao.springbootmall.pojo.Product;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductId(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
