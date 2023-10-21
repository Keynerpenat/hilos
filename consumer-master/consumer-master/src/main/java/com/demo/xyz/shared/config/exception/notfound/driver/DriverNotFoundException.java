package com.demo.xyz.shared.config.exception.notfound.driver;


import com.demo.xyz.shared.config.exception.notfound.NotFoundException;

public class DriverNotFoundException extends NotFoundException {

  public DriverNotFoundException(String id) {
    super(String.format("driver with ID: %s was not found", id));
  }
}
