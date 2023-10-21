package com.demo.xyz.service.impl.truck;

import com.demo.xyz.model.Truck;
import com.demo.xyz.service.TruckService;
import com.demo.xyz.repository.truck.TruckRepository;
import com.demo.xyz.repository.truck.TruckRepositoryMapper;
import com.demo.xyz.shared.config.exception.notfound.truck.TruckNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TruckImp implements TruckService {
  private final TruckRepository truckRepository;
  private final TruckRepositoryMapper truckRepositoryMapper;

  @Override
  public Truck saveTruck(Truck truck) {
    return truckRepositoryMapper.toEntity(truckRepository.save(truckRepositoryMapper.toDto(truck)));
  }

  @Override
  public Truck getTruck(Long truckId) {
    return truckRepositoryMapper.toEntity(truckRepository.findById(truckId)
        .orElseThrow(() -> new TruckNotFoundException(String.valueOf(truckId))));  }

  @Override
  public List<Truck> getAllTruck() {
    return truckRepositoryMapper.toEntity(truckRepository.findAll());
  }

  @Override
  public void deleteTruck(Long truckId) {
    truckRepository.deleteById(truckId);

  }

  @Override
  public void updateTruck(Long truckId, Truck truck) {
    truckRepository.update(truckId,truck.getGasoline(),truck.getGps(),truck.getState());

  }
}
