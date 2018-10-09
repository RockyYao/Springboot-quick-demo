package com.springboot.rabbitmq.rec;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {


    @RabbitListener(queues = "hello")
    public void process(String messqge){
        System.out.println("hello rec 1 fanout hello Receiver : " + messqge);
    }

    @RabbitListener(queues = "hello")
    public void process3(String messqge){
        System.out.println("hello rec 2 fanout hello Receiver : " + messqge);
    }


    @RabbitListener(queues = "helloObj")
    public void process2(String messqge){
        System.out.println("helloObj rec  1 fanout helloObj Receiver : " + messqge);
    }

    @RabbitListener(queues = "helloObj")
    public void process4(String messqge){
        System.out.println("helloObj rec 2 fanout helloObj Receiver : " + messqge);
    }


}
