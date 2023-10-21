package com.demo.xyz.comtroller.truck;

import com.demo.xyz.comtroller.driver.DriverResponse;
import com.demo.xyz.model.Driver;
import com.demo.xyz.model.Truck;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface TruckResponseMapper extends EntityToDto<Truck, TruckResponse> {

}