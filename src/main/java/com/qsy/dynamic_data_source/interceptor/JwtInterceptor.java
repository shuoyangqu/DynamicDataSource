package com.qsy.dynamic_data_source.interceptor;

import com.qsy.dynamic_data_source.config.datasource.service.DBChangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description: 数据源验证拦截器
 * @author: qsy
 * @create: 2020-06-23
 */
@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private DBChangeService DBChangeServiceImpl;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        response.setHeader("X-Powered-By","Jetty");

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        // 获取请求头信息authorization信息
        final String   datasourceToken = request.getHeader("Authorization");
        log.info("## authHeader= {}", datasourceToken);
        if (datasourceToken!=null) {
            DBChangeServiceImpl.changeDb(datasourceToken);
        }
        return true;
    }
}

