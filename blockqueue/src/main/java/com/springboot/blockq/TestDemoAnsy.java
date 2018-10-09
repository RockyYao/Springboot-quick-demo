package com.springboot.blockq;

import org.springframework.stereotype.Component;

@Component
public class TestDemoAnsy {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"主线程");
        }
        new Hello().sayhello();
    }
}
