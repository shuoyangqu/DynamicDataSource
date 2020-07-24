package com.qsy.dynamic_data_source.config.datasource.service;

/**
 * @description:
 * @author: qsy
 * @create: 2020-06-20
 */
import com.qsy.dynamic_data_source.config.datasource.vo.DataSource;

import java.util.List;


public interface DBChangeService {

    List<DataSource> get();

    boolean changeDb(String datasourceId) throws Exception;

}

