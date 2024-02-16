package com.ysmao.springbootmall.dao;

import com.ysmao.springbootmall.pojo.Product;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductDao {

    Product getProductId(Integer productId);

}
