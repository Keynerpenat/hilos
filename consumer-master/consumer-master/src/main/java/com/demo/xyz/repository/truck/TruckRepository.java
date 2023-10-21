package com.demo.xyz.repository.truck;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TruckRepository extends JpaRepository<TruckDto, Long> {
  @Modifying
  @Transactional
  @Query("UPDATE TruckDto p SET p.gasoline = :gasoline, p.gps = :gps, p.state = :state WHERE p.id = :truckId")
  void update(@Param("truckId") Long truckId,@Param("gasoline") Double gasoline,@Param("gps") String gps,@Param("state") String state);

}
