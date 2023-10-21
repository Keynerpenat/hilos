package com.demo.xyz.cosumer;

import com.demo.xyz.service.MetricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TruckConsumer {

  private final MetricService metricService;
  private MetricResponseMapper metricResponseMapper;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @RabbitListener(queues = {"camiones_cola"})
  public void consumer(String message) {
    MetricRespose metricRespose;
    try {
      metricRespose= toObject(message);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    System.out.println(message);
    metricService.saveMetric(metricResponseMapper.toEntity(metricRespose));



  }
  private MetricRespose toObject(String json) throws JsonProcessingException {
    MetricRespose metricRespose = objectMapper.readValue(json, MetricRespose.class);
    return metricRespose;
  }


}