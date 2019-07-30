package com.test.demo.service;

import com.test.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{


    private DemoDao demoDao;

    @Override
    public String serviceOne() {
        System.out.println("do service one");
        System.out.println(demoDao.sayHello());
        return "serviceOne";
    }

    @Override
    public int sercieTwo() {
        System.out.println("do service two");
        demoDao.make();
        return 0;
    }

    @Override
    public boolean serviceThree() {
        demoDao.sayHi();
        for (int i = 0; i < 3; i++){
            System.out.println("do service three");
        }
        return false;
    }

    @Override
    public void serviceFour(boolean isTrue) {
        if (isTrue) {
            demoDao.make();
            System.out.println("do service Four");
        } else {
            demoDao.sayHi();
            System.out.println("do not service Four");
        }

    }
}
