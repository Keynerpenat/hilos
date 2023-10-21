package com.example.publisher.producer;

import com.example.publisher.services.CreateMetricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Producer {
  private final RabbitTemplate template;
  private final CreateMetricService createMetricService;
  private final ObjectMapper objectMapper = new ObjectMapper();
  public void sendMessage() throws JsonProcessingException {
    while (true){
      Metric metric = createMetricService.createMetric();
      String metricJson = objectMapper.writeValueAsString(metric);
      System.out.println("message send: "+ metricJson);
      template.convertAndSend("camiones_topic_exchange","camiones_routing_key",metricJson);
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

  }

}
