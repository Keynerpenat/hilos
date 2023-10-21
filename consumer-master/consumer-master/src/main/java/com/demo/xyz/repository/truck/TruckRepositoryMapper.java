package com.demo.xyz.repository.truck;

import com.demo.xyz.model.Truck;
import com.demo.xyz.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;

@Mapper
public interface TruckRepositoryMapper extends EntityToDto<Truck, TruckDto>{
}
