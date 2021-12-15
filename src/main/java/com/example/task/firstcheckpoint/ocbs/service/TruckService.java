package com.example.task.firstcheckpoint.ocbs.service;

import com.example.task.firstcheckpoint.ocbs.dtos.Truck;
import com.example.task.firstcheckpoint.ocbs.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TruckService {

  private final TruckRepository truckRepository;

  @Autowired
  public TruckService(TruckRepository truckRepository) {
    this.truckRepository = truckRepository;
  }

  public List<Truck> getTrucks() { return truckRepository.findAll(); }

  public void addNewTruck(Truck truck) {
    Optional<Truck> truckOptional = truckRepository.findTruckByTruckNumber(truck.getTruckNumber());
    if(truckOptional.isPresent()) {
      throw new IllegalStateException("truck number taken");
    }
    truckRepository.save(truck);
  }

  public static class ResultObject {
    public String status;
    public int count;
  }

  @Transactional
  public void updateTruck(Truck truck, int newOccupiedSpace) {
    Optional<Truck> truckOptional = truckRepository.findTruckByTruckNumber(truck.getTruckNumber());
    if(truckOptional.isEmpty()) {
      throw new IllegalStateException("truck with given truck number not found");
    }

    int truckTotalSpace = truck.getTruckTotalSpace();
    int truckOccupiedSpace = truck.getTruckOccupiedSpace();

    if((truckOccupiedSpace + newOccupiedSpace) <= truckTotalSpace) {
      truck.setTruckOccupiedSpace(truckOccupiedSpace + newOccupiedSpace);
    } else {
      throw new IllegalStateException("Not enough space / Truck is full");
    }
  }

  @Transactional
  public void resetTruck(String truckNumber) {
    Truck truck = truckRepository.getTruckByTruckNumber(truckNumber);

    truck.setTruckOccupiedSpace(0);
  }

  public ResultObject getTruckAvailableSpaceByTruckNumber(String truckNumber) {
    truckRepository.findTruckByTruckNumber(truckNumber)
        .orElseThrow(() -> new IllegalStateException(
            "truck with truck number " + truckNumber + " does not exist"
        ));

    int result = truckRepository.getTruckTotalSpace(truckNumber) - truckRepository.getTruckOccupiedSpace(truckNumber);
    ResultObject resultObj = new ResultObject();
    if(result >= 0) {
      resultObj.status = "Success";
      resultObj.count = result;
    } else {
      resultObj.status = "Failure";
    }
    System.out.println("resultObj = " + resultObj);
    return resultObj;
  }
}
