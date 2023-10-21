package com.demo.xyz.comtroller.truck;

import com.demo.xyz.comtroller.driver.DriverRequest;
import com.demo.xyz.model.Driver;
import com.demo.xyz.model.Truck;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface TruckRequestMapper extends EntityToDto<TruckRequest, Truck> {





}
