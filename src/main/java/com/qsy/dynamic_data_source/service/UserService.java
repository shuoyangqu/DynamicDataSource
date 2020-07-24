package com.qsy.dynamic_data_source.service;

import com.qsy.dynamic_data_source.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: qsy
 * @create: 2020-06-20
 */
public interface UserService {
    List<User> queryUserInfo();
    int addUser(User user);
}
