package com.hou.learn.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @outhor ikan
 * @create 2019-02-22 10:56
 */
@Component
public class RabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg, String exchange, String routingKey){
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }
}