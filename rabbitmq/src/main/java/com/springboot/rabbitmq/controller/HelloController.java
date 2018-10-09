package com.springboot.rabbitmq.controller;

import com.springboot.rabbitmq.sender.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    private HelloSender helloSender;

    @RequestMapping("/test")
    public void hello(){
        helloSender.simpleSend();
    }

    @RequestMapping("/testfanout")
    public void hellofanout(){
        helloSender.fanoutSend();
    }

    @RequestMapping("/testtopic")
    public void hellotopic(){
        helloSender.topicSend();
    }


    @RequestMapping("/testdirect")
    public void hellodirect(){
        helloSender.directSend();
    }

}
