package com.lmq;

import com.lmq.BaseService.LmqService;
import com.lmq.config.AppConfig;
import com.lmq.dao.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext lmqcontext = new AnnotationConfigApplicationContext(AppConfig.class);
        //方式一
      // LmqService lmq = lmqcontext.getBean(LmqService.class);
       // LmqService lmq = lmqcontext.getBean("lmqService");
       // lmq.printSys();
     //   UserMapper lmq = (UserMapper) lmqcontext.getBean("userMapper");
    //    lmq.findUserInfo("asdd");

    //    AppConfig appconfig = (AppConfig) lmqcontext.getBean("appConfig");

        lmqcontext.close();

    }


}
