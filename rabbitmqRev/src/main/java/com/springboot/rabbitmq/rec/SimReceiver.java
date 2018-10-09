package com.springboot.rabbitmq.rec;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 简单的的 生产者直接发送消息到队列  后台接受
 */

@Component
@RabbitListener(queues = "simple")//监听队列
public class SimReceiver {

    /**
     * deliveryTag（唯一标识 ID）：当一个消费者向 RabbitMQ 注册后，会建立起一个 Channel ，RabbitMQ 会用 basic.deliver 方法向消费者推送消息，这个方法携带了一个 delivery tag， 它代表了 RabbitMQ 向该 Channel 投递的这条消息的唯一标识 ID，是一个单调递增的正整数，delivery tag 的范围仅限于 Channel
     * multiple：为了减少网络流量，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
     *
     *确认消息
     * @param context
     * @param channel
     * @param tag
     */
    @RabbitHandler//@RabbitHandler注解来指定对消息的处理方法
    public void process(String context, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag){

        System.out.println("SimReceiver : " + context);

        try {
            channel.basicAck(tag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
