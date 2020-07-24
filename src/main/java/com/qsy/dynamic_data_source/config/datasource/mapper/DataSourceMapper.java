package com.qsy.dynamic_data_source.config.datasource.mapper;


import com.qsy.dynamic_data_source.config.datasource.vo.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DataSourceMapper {
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Select("SELECT * FROM databasesource")
   public List<DataSource> get(){
        BeanPropertyRowMapper beanPropertyRowMapper=BeanPropertyRowMapper.newInstance(DataSource.class);
        try {
            Object oj=  jdbcTemplate.query("SELECT datasource_id,url,user_name,pass_word,`code`,databasetype FROM databasesource",beanPropertyRowMapper);
            List<DataSource> dataSources= (List<DataSource>) oj;
            return dataSources;
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ArrayList<>(0);

    }


}
