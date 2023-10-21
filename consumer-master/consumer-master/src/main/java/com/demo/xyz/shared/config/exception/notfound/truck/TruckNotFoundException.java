package com.demo.xyz.shared.config.exception.notfound.truck;


import com.demo.xyz.shared.config.exception.notfound.NotFoundException;

public class TruckNotFoundException extends NotFoundException {

  public TruckNotFoundException(String id) {
    super(String.format("truck with ID: %s was not found", id));
  }
}
