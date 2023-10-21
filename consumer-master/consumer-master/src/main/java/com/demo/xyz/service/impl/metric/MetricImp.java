package com.demo.xyz.service.impl.metric;


import com.demo.xyz.model.Metric;
import com.demo.xyz.repository.metric.MetricRepository;
import com.demo.xyz.repository.metric.MetricRepositoryMapper;
import com.demo.xyz.service.MetricService;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MetricImp implements MetricService {
  private final MetricRepository metricRepository;
  private final MetricRepositoryMapper metricRepositoryMapper;
  public static Map<String, Thread> plateThreadMap = new HashMap<>();

  @Override
  public Metric saveMetric(Metric metric) {
    String plate = metric.getPlate();

    if (plateThreadMap.containsKey(plate)) {
      Thread existingThread = plateThreadMap.get(plate);
      processMetricInThread(existingThread, metric);
    } else {
      Thread newThread = new Thread(() -> {
        processMetricInThread(Thread.currentThread(), metric);
      });
      plateThreadMap.put(plate, newThread);
      newThread.start();
    }

    return metric;
  }

  private void processMetricInThread(Thread thread, Metric metric) {
    System.out.println("Processing metric in thread: " + thread.getName());
    metricRepository.save(metricRepositoryMapper.toDto(metric));
  }
}


