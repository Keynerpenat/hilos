package com.demo.xyz.comtroller.truck;

import com.demo.xyz.service.TruckService;
import java.util.List;
import lombok.AllArgsConstructor;
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
@RequestMapping("/truck")
@AllArgsConstructor
public class TruckController {
  private final TruckService truckService;
  private final TruckRequestMapper truckRequestMapper;
  private final TruckResponseMapper truckResponseMapper;

  @PostMapping
  public ResponseEntity<TruckResponse> saveTruck(@RequestBody TruckRequest request){
    return new ResponseEntity<>(truckResponseMapper.toDto(truckService.saveTruck(truckRequestMapper.toDto(request))),
        HttpStatus.CREATED);
  }
  @GetMapping("/search/{truckId}")
  public ResponseEntity<TruckResponse> getTruck(@PathVariable("truckId") Long truckId){
    return ResponseEntity.ok(truckResponseMapper.toDto(truckService.getTruck(truckId)));}
  @GetMapping
  public ResponseEntity<List<TruckResponse>> getAllTruck(){
    return ResponseEntity.ok(truckResponseMapper.toDto(truckService.getAllTruck()));}
  @DeleteMapping("/delete/{truckId}")
  public void deleteTruck(@PathVariable("truckId") Long truckId){
    truckService.deleteTruck(truckId);}
  @PutMapping("/update/{truckId}")
  public void updateDriver(@PathVariable("truckId") Long truckId,@RequestBody TruckRequest request){
    truckService.updateTruck(truckId,truckRequestMapper.toDto(request));}
}
