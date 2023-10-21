package com.demo.xyz.repository.drive;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepository extends JpaRepository<DriverDto, Long> {
  @Modifying
  @Transactional
  @Query("UPDATE DriverDto p SET p.name = :name WHERE p.id = :driverId")
  void update(@Param("driverId") Long driverId,@Param("name") String name);
}
