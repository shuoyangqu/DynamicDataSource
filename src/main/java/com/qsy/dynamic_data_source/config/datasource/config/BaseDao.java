package com.qsy.dynamic_data_source.config.datasource.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public interface BaseDao  {
      JdbcTemplate  getJdbcTemplate();

}
