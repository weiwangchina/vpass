package com.isstech.vpass.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 14:33
 * @Version 1.0.0
 */
@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendTo(String routingkey,String message){
//        log.info("Sending> ..." + message);
        this.rabbitTemplate.convertAndSend(routingkey,message);
    }
}
