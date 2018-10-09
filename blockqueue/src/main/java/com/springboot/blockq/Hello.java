package com.springboot.blockq;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class Hello {

    public static Random random =new Random();
    @Async
    public void sayhello(){
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"hello "+i);
        }
    }

    @Async
    public Future<String> test1() throws InterruptedException {
        System.out.println("test1 begin");
        long begin = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        System.out.println("test1 end " + (System.currentTimeMillis() - begin));
        return new AsyncResult<String>("test1 is done!");
    }
    @Async
    public Future<String> test2() throws InterruptedException {
        System.out.println("test2 begin");
        long begin = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        System.out.println("test2 end " + (System.currentTimeMillis() - begin));
        return new AsyncResult<String>("test2 is done!");
    }

    @Async
    public Future<String> test3() throws InterruptedException {
        System.out.println("test3 begin");
        long begin = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        System.out.println("test3 end " + (System.currentTimeMillis() - begin));
        return new AsyncResult<String>("test3 is done!");
    }
}
