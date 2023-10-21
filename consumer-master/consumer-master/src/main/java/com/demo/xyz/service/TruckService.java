package com.demo.xyz.service;

import com.demo.xyz.model.Driver;
import com.demo.xyz.model.Truck;
import java.util.List;

public interface TruckService {
  Truck saveTruck(Truck truck);
  Truck getTruck(Long truckId);
  List<Truck> getAllTruck();

  void deleteTruck(Long truckId);
  void updateTruck(Long truckId, Truck truck);


}
