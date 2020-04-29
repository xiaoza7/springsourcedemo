package com.lmq.BaseService;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor , PriorityOrdered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(beanName.equals("lmqService"))
       {
           System.out.println("before initialization!");
       }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lmqService"))
        {
            System.out.println("after initialization!");
        }

        return bean;
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
