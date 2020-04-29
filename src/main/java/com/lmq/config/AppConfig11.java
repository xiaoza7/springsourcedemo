package com.lmq.config;


import com.lmq.BaseService.*;
import com.lmq.daobase.EnableLmqUtil;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@ComponentScan("com.lmq.BaseService")
@ComponentScan("com.lmq.daobase")
@ComponentScan("com.lmq.aspects")
@ComponentScan("com.lmq.circus")
//@Import(MyImportBeanDefinitionRegistrar.class)
//@Import(MyImportSelector.class)
//@EnableAspectJAutoProxy
@EnableTransactionManagement
//@EnableLmqUtil
public class AppConfig {


    @Bean
     public    lmqDao indexdao()
    {
        return new lmqDao();
    }

    @Bean
    public lmqDao1 indexdao1()
    {
        indexdao();//没有@configuration会输出2次，在加了@configuration，只会输出1遍“lmqdao-init",因为被cglib代理，只会创建一个lmqdao,构造函数也就输出一次
        return new lmqDao1();
    }


}







