package com.demo.xyz.service.impl.drive;

import com.demo.xyz.model.Driver;
import com.demo.xyz.service.DriverService;
import com.demo.xyz.repository.drive.DriverRepository;
import com.demo.xyz.repository.drive.DriverRepositoryMapper;
import com.demo.xyz.shared.config.exception.notfound.driver.DriverNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverImp implements DriverService {
  private final DriverRepository driverRepository;
  private final DriverRepositoryMapper driverRepositoryMapper;


  @Override
  public Driver saveDrive(Driver driver) {
    return driverRepositoryMapper.toEntity(driverRepository.save(driverRepositoryMapper.toDto(driver)));
  }
  @Override
  public Driver getDrive(Long driveId)  {
    return driverRepositoryMapper.toEntity(driverRepository.findById(driveId)
        .orElseThrow(() -> new DriverNotFoundException(String.valueOf(driveId))));
  }

  @Override
  public List<Driver> getAllDriver() {
    return driverRepositoryMapper.toEntity(driverRepository.findAll());
  }

  @Override
  public void deleteDriver(Long driveId) {
    driverRepository.deleteById(driveId);

  }

  @Override
  public void updateDriver(Long driveId, Driver driver) {
    driverRepository.update(driveId,driver.getName());


  }
}
