package com.ysmao.springbootmall.dao;

import com.ysmao.springbootmall.dto.UserRegisterRequest;
import com.ysmao.springbootmall.pojo.User;

public interface UserDao {
    User getUserById(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
