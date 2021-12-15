package com.example.task.firstcheckpoint.ocbs.repository;

import com.example.task.firstcheckpoint.ocbs.dtos.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, Long> {

  @Query("SELECT truck FROM Truck truck WHERE truck.truckNumber = ?1")
  Optional<Truck> findTruckByTruckNumber(String truckNumber);

  @Query("SELECT truck FROM Truck truck WHERE truck.truckNumber = ?1")
  Truck getTruckByTruckNumber(String truckNumber);

  @Query(nativeQuery = true, value = "SELECT truck_Total_Space FROM truck WHERE truck_Number = :truckNumber ;")
  int getTruckTotalSpace(@Param(value = "truckNumber") String truckNumber);

  @Query(nativeQuery = true, value = "SELECT truck_Occupied_Space FROM truck WHERE truck_Number = :truckNumber ;")
  int getTruckOccupiedSpace(@Param(value = "truckNumber") String truckNumber);

}
