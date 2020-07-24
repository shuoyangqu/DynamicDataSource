package com.qsy.dynamic_data_source.controller;


import com.qsy.dynamic_data_source.config.datasource.config.DBContextHolder;
import com.qsy.dynamic_data_source.config.datasource.service.DBChangeService;
import com.qsy.dynamic_data_source.pojo.User;
import com.qsy.dynamic_data_source.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {


    @Autowired
    private DBChangeService dbChangeServiceImpl;
    @Autowired
    UserService userService;




    /**
     * 查询所有
     * @return
     */
//    @GetMapping("/test")
//    public  String test() throws Exception {
//
//        //切换到数据库dbtest2
//        String datasourceId="dbtest2";
//        dbChangeServiceImpl.changeDb(datasourceId);
//        List<User> userList= userService.queryUserInfo();
//        System.out.println(userList.toString());
//
//        //再切换到数据库dbtest3
//        dbChangeServiceImpl.changeDb("dbtest3");
//        List<User> userList3= userService.queryUserInfo();
//        System.out.println(userList3.toString());
//
//
//        //切回主数据源
//        DBContextHolder.clearDataSource();
//        return "ok";
//    }
    @GetMapping("/test")
    @Transactional(rollbackFor = Exception.class)
    public String test()throws Exception{
        User userDb2=new User();
        userDb2.setUserName("Db2User");
        userDb2.setAge("100");
        User userDb3=new User();
        userDb3.setUserName("Db3User");
        userDb3.setAge("50");
        try {
            //切换到数据库dbtest2
            dbChangeServiceImpl.changeDb("tssen_fms_b");
            userService.addUser(userDb2);
//            //再切换到数据库3
//            dbChangeServiceImpl.changeDb("tssen_fms_c");
//            userService.addUser(userDb3);
//            int num=1/0;
        }catch (Exception e){
            System.out.println("触发事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();;
        }
        //切回主数据源
        DBContextHolder.clearDataSource();
        return "ok";



    }

}
