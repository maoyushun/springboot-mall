package com.ysmao.springbootmall.dao.impl;

import com.ysmao.springbootmall.dao.ProductDao;
import com.ysmao.springbootmall.pojo.Product;
import com.ysmao.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Product getProductId(Integer productId) {
        String sql = "SELECT  product_id, product_name, category, image_url, price, stock, description," +
                " created_date, last_modified_date " +
                " FROM product WHERE product_id = :productId";

        Map<String, Object>  map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }
}
