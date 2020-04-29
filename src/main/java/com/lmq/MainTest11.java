package com.lmq;

import com.lmq.BaseService.lmqDao;
import com.lmq.config.AppConfig;
import com.lmq.myinterface.TestMethodCallBack;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext lmqcontext = new AnnotationConfigApplicationContext(AppConfig.class);
        //方式一
      // LmqService lmq = lmqcontext.getBean(LmqService.class);
       // LmqService lmq = lmqcontext.getBean("lmqService");
       // lmq.printSys();
     //   UserMapper lmq = (UserMapper) lmqcontext.getBean("userMapper");
    //    lmq.findUserInfo("asdd");

     AppConfig appconfig = (AppConfig) lmqcontext.getBean("appConfig");


        Enhancer enhancer =new Enhancer();
        //增强父类，
        enhancer.setSuperclass(lmqDao.class);

        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);

        //对目标的代理对象的所有方法拦截
        enhancer.setCallback(new TestMethodCallBack());

        lmqDao lmqdao= (lmqDao) enhancer.create();

        lmqdao.print();
      //  System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        try {
            System.in.read();
        }catch(Exception e)
        {
            e.printStackTrace();
        }








        lmqcontext.close();

    }


}
