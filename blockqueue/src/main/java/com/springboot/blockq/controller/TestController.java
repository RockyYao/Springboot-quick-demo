package com.springboot.blockq.controller;

import com.springboot.blockq.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TestController {

    @Autowired
    private Hello hello;

    @RequestMapping("/demo")
    public void sayhello(){
        hello.sayhello();
        hello.sayhello();
        hello.sayhello();
            for (int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+"主线程");
            }

        }


    @RequestMapping("/demo2")
    public void sayhello2() throws InterruptedException, ExecutionException {
        System.out.println("begin");
        long begin = System.currentTimeMillis();
        Future<String> test1 = hello.test1();
        Future<String> test2 = hello.test2();
        Future<String> test3 = hello.test3();

        while(true) {
            if(test1.isDone() && test2.isDone() && test3.isDone()){
                System.out.println(test1.get()+test2.get()+test3.get());
                break;
            }



            Thread.sleep(500);
        }

        System.out.println("end 耗时: " + (System.currentTimeMillis() - begin));
    }
    }



