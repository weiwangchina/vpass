package com.isstech.vpass.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicConfig
 * @Description TODO
 * @Author issuser
 * @Date 2019/7/12 14:15
 * @Version 1.0.0
 */
@Configuration
@Component
public class TopicConfig {

    @Value("${queuefile}")
    String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

}
