package com.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
 Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
 Queue:消息的载体,每个消息都会被投到一个或多个队列。
 Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
 Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
 vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。
 Producer:消息生产者,就是投递消息的程序.
 Consumer:消息消费者,就是接受消息的程序.
 Channel:消息通道,在客户端的每个连接里,可建立多个channel.
 */

@Configuration
public class RabbitConfig {

    //简单创个队列  生产者对消费者  1对1   1对多:多个消费者抢一个消息   多对多：和一堆多一样  springboot对bean实例有比较好的支持可以直接发和取
    @Bean(name = "QueueD")
    public Queue queueD(){
        return new Queue("simple",true);
    }
/*
    @Bean(name = "QueueC")
    public Queue queueC(){
        return new Queue("DirectQueue");
    }*/
//----------------------------------------------------------------fanout ---------------------------------------------
    @Bean(name = "QueueA")
    public Queue queueA(){
        return new Queue("hello",true);
    }

    @Bean(name = "QueueB")
    public Queue queueB(){
        return new Queue("helloObj",true);
    }
    /**     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。     * @return     */
    @Bean
    public FanoutExchange fanoutExchange() {

        return new FanoutExchange("fanoutExchange");

    }
    @Bean
    public Binding bindingExangeA(@Qualifier(value = "QueueA") Queue queueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExangeB(@Qualifier(value = "QueueB")Queue queueB,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

//----------------------------------------------------------------topic ---------------------------------------------
    @Bean(name = "topicMessage")
    Queue quequeE(){
        return new Queue("topic.message",true);
    }

    @Bean(name = "topicMessages")
    Queue quequeF(){
        return new Queue("topic.messages",true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    /**
     *      * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     *      * @param queueMessage
     *      * @param exchange
     *      * @return
     *      
     */
    @Bean
    Binding bindingExchangeMessage(@Qualifier(value = "topicMessage") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     *         #代表0个或多个 *代表一个
     *      * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     *      * @param queueMessage
     *      * @param exchange
     *      * @return
     *      
     */
    @Bean
    Binding bindingExchangeMessages(@Qualifier(value = "topicMessages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
//-----------------------------------------------Direct----------------------------------------------

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean(name = "direct1")
    Queue queueG(){
        return new Queue("direct.1");
    }

    @Bean(name = "direct2")
    Queue queueH(){
        return new Queue("direct.2");
    }

    @Bean
    Binding bindingDirect(@Qualifier(value = "direct1")Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("direct1");
    }

    @Bean
    Binding bindingDirect2(@Qualifier(value = "direct2")Queue queue,DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("direct2");
    }
}
