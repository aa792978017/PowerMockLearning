package com.test.demo.controller;


import com.test.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    public String serviceOne() {
        System.out.println("i am serviceOne");
        return demoService.serviceOne();
    }

    public void serviceTwo() {
        System.out.println("i am serviceTwo");
        demoService.sercieTwo();
    }

    public void serviceThree() {
        try{
            System.out.println("i am serviceThree");
            demoService.serviceThree();
        }catch (Exception e){
            System.out.println("do serviceThree fail");
            System.out.println(e.getMessage());
        }
    }

    public void serviceFour(boolean isTrue) {
        System.out.println("i am serviceFour, isTrue = "+isTrue);
        if (isTrue) {
            demoService.serviceFour(isTrue);
        }else {
            System.out.println("do not serviceFour");
        }
    }

}
