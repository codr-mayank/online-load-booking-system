package com.example.task.firstcheckpoint.ocbs.controllers;

import com.example.task.firstcheckpoint.ocbs.dtos.Truck;
import com.example.task.firstcheckpoint.ocbs.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "truck")
public class TruckController {

  private final TruckService truckService;

  @Autowired
  public TruckController(TruckService truckService) {
    this.truckService = truckService;
  }

  @GetMapping
  public List<Truck> getTrucks() {
    return truckService.getTrucks();
  }

  @PostMapping
  public void scheduleNewTruck(@RequestBody Truck truck) {
    truckService.addNewTruck(truck);
  }

  @PutMapping(path = "reset/{truckNumber}")
  public void resetTruck(@PathVariable String truckNumber) {
    truckService.resetTruck(truckNumber);
  }

  @GetMapping(path = "getAvailableSpace")
  public TruckService.ResultObject getTruckAvailableSpace(@RequestParam String truckNumber) {
    return truckService.getTruckAvailableSpaceByTruckNumber(truckNumber);
  }

}
