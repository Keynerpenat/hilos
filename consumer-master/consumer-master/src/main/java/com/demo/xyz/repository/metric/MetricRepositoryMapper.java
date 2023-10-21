package com.demo.xyz.repository.metric;

import com.demo.xyz.model.Metric;
import com.demo.xyz.model.Truck;
import com.demo.xyz.repository.truck.TruckDto;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface MetricRepositoryMapper extends EntityToDto<Metric, MetricDto>{
}
