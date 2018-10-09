package com.springboot.rabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {

    @RabbitListener(queues = "topic.message")
  public void  process(String message ){
      System.out.println("topic.message  rec  1  Receiver : " + message);
  }

    @RabbitListener(queues = "topic.messages")
    public void  process2(String message ){
        System.out.println("topic.messages  rec  1  Receiver : " + message);
    }


}
