package com.example.task.firstcheckpoint.ocbs.service;

import com.example.task.firstcheckpoint.ocbs.dtos.Load;
import com.example.task.firstcheckpoint.ocbs.dtos.Truck;
import com.example.task.firstcheckpoint.ocbs.repository.LoadRepository;
import com.example.task.firstcheckpoint.ocbs.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

  private final TruckService truckService;
  private final TruckRepository truckRepository;
  private final LoadRepository loadRepository;

  @Autowired
  public LoadService(TruckService truckService, TruckRepository truckRepository, LoadRepository loadRepository) {
    this.truckService = truckService;
    this.truckRepository = truckRepository;
    this.loadRepository = loadRepository;
  }

  public List<Load> getLoads() { return loadRepository.findAll(); }

  public void bookLoad(Load load) {
    Optional<Truck> truckOptional = truckRepository.findTruckByTruckNumber((load.getTruckNumber()));
    if (truckOptional.isEmpty()) {
      throw new IllegalStateException("truck with truck number " + load.getTruckNumber() + " not found");
    } else {
      Optional<Load> loadOptional = loadRepository.findLoadByLoadNumber((load.getLoadNumber()));
      if (loadOptional.isPresent()) {
        throw new IllegalStateException("laod with load number " + load.getLoadNumber() + " already present");
      }
      Truck truck = truckRepository.getTruckByTruckNumber(load.getTruckNumber());
      truckService.updateTruck(truck, load.getSpaceRequired());
      loadRepository.save(load);
    }
  }
}
