package com.ysmao.springbootmall.service;

import com.ysmao.springbootmall.dto.UserRegisterRequest;
import com.ysmao.springbootmall.pojo.User;

public interface UserService {
    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

}
