package com.lmq.BaseService;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class LmqService {
    public LmqService()
    {
        System.out.println("构造lmqservice");
    }

   // @PostConstruct
    public void init()
    {
        System.out.println("lmqservice init!");
    }
    public void printSys()
    {
        System.out.println("lmq is in service......");
    }
}
