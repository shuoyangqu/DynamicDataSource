package com.qsy.dynamic_data_source.config.datasource.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: qsy
 * @create: 2020-06-20
 */
@Data
@ToString
public class DataSource {
    String datasourceId;
    String url;
    String userName;
    String passWord;
    String code;
    String databasetype;

}
