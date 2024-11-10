package com.ysmao.springbootmall.service.impl;

import com.ysmao.springbootmall.dao.UserDao;
import com.ysmao.springbootmall.dto.UserLoginRequest;
import com.ysmao.springbootmall.dto.UserRegisterRequest;
import com.ysmao.springbootmall.pojo.User;
import com.ysmao.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }



    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊 mail
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        // 檢查User是否存在
        if (user != null) {
            log.warn("{} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        // 檢查User是否存在
        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        // 檢查密碼
        if (user.getPassword().equals(hashedPassword)) {
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}
