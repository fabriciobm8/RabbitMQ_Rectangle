// JavaRabbitMQConfig.java
package com.example.java_rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaRabbitMQConfig {

  public static final String QUEUE_NAME = "retangulo";

  @Bean
  public Queue retanguloQueue() {
    return new Queue(QUEUE_NAME, false);
  }
}
