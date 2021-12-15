package com.example.task.firstcheckpoint.ocbs.dtos;

import javax.persistence.*;

@Entity
@Table
public class Truck {

  @Id
  @SequenceGenerator(
      name = "truck_sequence",
      sequenceName = "truck_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "truck_sequence"
  )
  private Long id;
  private String truckNumber;
  private int truckTotalSpace;
  private int truckOccupiedSpace;

  @Transient
  private int truckAvailableSpace;

  public Truck() {
  }

  public Truck(Long id, String truckNumber, int truckTotalSpace, int truckOccupiedSpace) {
    this.id = id;
    this.truckNumber = truckNumber;
    this.truckTotalSpace = truckTotalSpace;
    this.truckOccupiedSpace = truckOccupiedSpace;
  }

  public Truck(String truckNumber, int truckTotalSpace, int truckOccupiedSpace) {
    this.truckNumber = truckNumber;
    this.truckTotalSpace = truckTotalSpace;
    this.truckOccupiedSpace = truckOccupiedSpace;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTruckNumber() {
    return truckNumber;
  }

  public void setTruckNumber(String truckNumber) {
    this.truckNumber = truckNumber;
  }

  public int getTruckTotalSpace() {
    return truckTotalSpace;
  }

  public void setTruckTotalSpace(int truckTotalSpace) {
    this.truckTotalSpace = truckTotalSpace;
  }

  public int getTruckOccupiedSpace() {
    return truckOccupiedSpace;
  }

  public void setTruckOccupiedSpace(int truckOccupiedSpace) {
    this.truckOccupiedSpace = truckOccupiedSpace;
  }

  public int getTruckAvailableSpace() {
    return (this.truckTotalSpace - this.truckOccupiedSpace);
  }

  public void setTruckAvailableSpace(int truckAvailableSpace) {
    this.truckAvailableSpace = truckAvailableSpace;
  }

  @Override
  public String toString() {
    return "truck{" +
        "id=" + id +
        ", truckNumber='" + truckNumber + '\'' +
        ", truckTotalSpace=" + truckTotalSpace +
        ", truckOccupiedSpace=" + truckOccupiedSpace +
        ", truckAvailableSpace=" + truckAvailableSpace +
        '}';
  }
}
