package com.aorun.epoint.rabbitmq_direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.integralQueue, context);
    }

    public void send2(int i) {
        String context = "hello " + new Date() + "      " + i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend(RabbitConfig.integralQueue, context);
    }

}