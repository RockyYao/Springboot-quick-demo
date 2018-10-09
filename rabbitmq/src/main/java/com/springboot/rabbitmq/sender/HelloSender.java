package com.springboot.rabbitmq.sender;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HelloSender{

    @Autowired
    private RabbitTemplate rabbitTemplate;

     public void simpleSend(){
    String context="你好现在是"+new Date()+"simple";
    System.out.println("发送内容 : "+context);
    rabbitTemplate.convertAndSend("simple",context);
}

//订阅广播模式  routingKey就算指定了也没用 ，所有消费者都收的到消息
    public void fanoutSend(){
        String context="你好现在是"+new Date()+"fanout ";
        System.out.println("发送内容 : "+context);
        rabbitTemplate.convertAndSend("fanoutExchange","topic.message",context);
    }
//topic 匹配  根据binding key路由消息 到哪个队列
    public void topicSend(){
        String context="sender 1 你好现在是"+new Date()+"topic message ";
        System.out.println("发送内容 : "+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.message",context);

        String context2="sender 2 你好现在是"+new Date()+"topic messages ";
        System.out.println("发送内容 : "+context2);
        rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);

    }


    public void directSend(){
        String context="sender 1 你好现在是"+new Date()+"direct1 message ";
        System.out.println("发送内容 : "+context);
        rabbitTemplate.convertAndSend("directExchange","direct1",context);

        String context2="sender 2 你好现在是"+new Date()+"direct2 messages ";
        System.out.println("发送内容 : "+context2);
        rabbitTemplate.convertAndSend("directExchange","direct2",context);
    }

/*    public void sendDirect(){
        rabbitTemplate.convertAndSend("DirectQueue","hello,rabbit~");
    }


    public void send(){
        String context="你好现在是"+new Date()+"";
        System.out.println("发送内容 : "+context);

        rabbitTemplate.setReturnCallback(this);


        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (!ack){
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            }else {
                System.out.println("HelloSender 消息发送成功 ");
            }

        }));


        rabbitTemplate.convertAndSend("ABExchange",context);


    }





    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
    }*/
}
