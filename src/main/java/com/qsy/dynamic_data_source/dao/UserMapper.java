package com.qsy.dynamic_data_source.dao;

/**
 * @description:
 * @author: qsy
 * @create: 2020-06-20
 */

import com.qsy.dynamic_data_source.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public  class UserMapper {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  List<User> queryUserInfo(){
        return null;
    }


    public  int addUser(User user){
        jdbcTemplate.execute("insert user values('zhangsan','100')");
         return 1;
    }
}
