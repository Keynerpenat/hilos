package com.demo.xyz.cosumer;

import com.demo.xyz.comtroller.driver.DriverResponse;
import com.demo.xyz.model.Driver;
import com.demo.xyz.model.Metric;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface MetricResponseMapper extends EntityToDto<Metric, MetricRespose> {

}