package com.demo.xyz.comtroller.driver;

import com.demo.xyz.service.DriverService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
@AllArgsConstructor
public class DriverController {
  private final DriverService driverService;
  private final DriverRequestMapper driverRequestMapper;
  private final DriverResponseMapper driverResponseMapper;

  @PostMapping
  public ResponseEntity<DriverResponse> saveDriver(@RequestBody DriverRequest request){
    return new ResponseEntity<>(driverResponseMapper.toDto(driverService.saveDrive(driverRequestMapper.toDto(request))),
        HttpStatus.CREATED);
  }
  @GetMapping("/search/{driverId}")
  public ResponseEntity<DriverResponse> getDriver(@PathVariable("driverId") Long driverId){
    return ResponseEntity.ok(driverResponseMapper.toDto(driverService.getDrive(driverId)));}
  @GetMapping
  public ResponseEntity<List<DriverResponse>> getAllDriver(){
    return ResponseEntity.ok(driverResponseMapper.toDto(driverService.getAllDriver()));}
  @DeleteMapping("/delete/{driverId}")
  public void deleteDriver(@PathVariable("driverId") Long driverId){
    driverService.deleteDriver(driverId);}
  @PutMapping("/update/{driverId}")
  public void updateDriver(@PathVariable("driverId") Long driverId,@RequestBody DriverRequest request){
    driverService.updateDriver(driverId,driverRequestMapper.toDto(request));}
}
