package com.demo.xyz.comtroller.driver;

import com.demo.xyz.model.Driver;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface DriverResponseMapper extends EntityToDto<Driver, DriverResponse> {

}