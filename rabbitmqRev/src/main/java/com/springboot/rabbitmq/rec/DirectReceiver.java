package com.springboot.rabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {

    @RabbitListener(queues = "direct.1")
    public void process(String message){
        System.out.println("direct.1 : " + message);
    }

    @RabbitListener(queues = "direct.2")
    public void process2(String message){
        System.out.println("direct.2 : " + message);
    }

}
