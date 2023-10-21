package com.demo.xyz.repository.drive;

import com.demo.xyz.model.Driver;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface DriverRepositoryMapper extends EntityToDto<Driver, DriverDto>{

}
