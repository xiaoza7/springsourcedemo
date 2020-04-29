package com.lmq.BaseService;

import com.lmq.MainTest;
import com.lmq.dao.UserMapper;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /**
         * 得到bd,或者类信息，这里对于接口类，假设实现创建代理对象,
         */
        //这里先写死去为某个接口去创建动态代理对象，其实可以模拟扫描注解的接口，类似mybatis的mapperscan, UserMapper是个接口

//        UserMapper userMapper= (UserMapper) Proxy.newProxyInstance(MainTest.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("in proxy");
//                return null;
//            }
//        });

       // BeanDefinitionBuilder beanDefinitionBuilder= BeanDefinitionBuilder.genericBeanDefinition(userMapper.getClass()); //实际无法获取代理类信息，使用factorybean
        BeanDefinitionBuilder beanDefinitionBuilder= BeanDefinitionBuilder.genericBeanDefinition(UserMapper.class);
        GenericBeanDefinition beanDefinition= (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();

        //为了传参数，可以给bd添加构造函数
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.lmq.dao.UserMapper");
        beanDefinition.setBeanClass(MyFactoryBean.class); //MyFactoryBean不能加Componenrt注解
        registry.registerBeanDefinition("userMapper",beanDefinition);
    }
}
