package com.qsy.dynamic_data_source.service;

import com.qsy.dynamic_data_source.pojo.User;
import com.qsy.dynamic_data_source.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @description:
 * @author: qsy
 * @create: 2020-06-20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryUserInfo() {
        return userMapper.queryUserInfo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(User user) {
        int i=0;
        try {
            i=userMapper.addUser(user);
//            int num=1/0;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("addUser 事务回滚触发");
        }
        return i;
    }


}
