package com.demo.xyz.service;

import com.demo.xyz.model.Driver;
import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface DriverService {
  Driver saveDrive(Driver driver);
  Driver getDrive(Long driveId);
  List<Driver> getAllDriver();

  void deleteDriver(Long driveId);
  void updateDriver(Long driveId, Driver driver);

}
