package com.ysmao.springbootmall.service.impl;

import com.ysmao.springbootmall.dao.UserDao;
import com.ysmao.springbootmall.dto.UserRegisterRequest;
import com.ysmao.springbootmall.pojo.User;
import com.ysmao.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }



    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
