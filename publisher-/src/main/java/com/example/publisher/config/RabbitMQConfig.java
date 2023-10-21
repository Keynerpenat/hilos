package com.example.publisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  @Bean
  public Queue queue(){
    return new Queue("camiones_cola");
  }
  @Bean
  public TopicExchange exchange(){
    return new TopicExchange("camiones_topic_exchange");
  }
  @Bean
  public Binding binding(){
    return BindingBuilder
        .bind(queue())
        .to(exchange())
        .with("camiones_routing_key");
  }



}
