package com.hou.learn.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @outhor ikan
 * @create 2019-02-22 11:32
 */
@Component
public class Consumer {
    @RabbitListener(queues = "mq-queue")
    public void consumer(String msg){
        System.out.println(msg);
    }
}