package com.example.task.firstcheckpoint.ocbs.dtos;

import javax.persistence.*;

@Entity
@Table
public class Load {

  @Id
  @SequenceGenerator(
      name = "load_sequence",
      sequenceName = "load_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "load_sequence"
  )
  private Long id;
  private String loadNumber;
  private String truckNumber;
  private int spaceRequired;

  public Load() {
  }

  public Load(Long id, String loadNumber, String truckNumber, int spaceRequired) {
    this.id = id;
    this.loadNumber = loadNumber;
    this.truckNumber = truckNumber;
    this.spaceRequired = spaceRequired;
  }

  public Load(String loadNumber, String truckNumber, int spaceRequired) {
    this.loadNumber = loadNumber;
    this.truckNumber = truckNumber;
    this.spaceRequired = spaceRequired;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLoadNumber() {
    return loadNumber;
  }

  public void setLoadNumber(String loadNumber) {
    this.loadNumber = loadNumber;
  }

  public String getTruckNumber() {
    return truckNumber;
  }

  public void setTruckNumber(String truckNumber) {
    this.truckNumber = truckNumber;
  }

  public int getSpaceRequired() {
    return spaceRequired;
  }

  public void setSpaceRequired(int spaceRequired) {
    this.spaceRequired = spaceRequired;
  }

  @Override
  public String toString() {
    return "Load{" +
        "id=" + id +
        ", loadNumber='" + loadNumber + '\'' +
        ", truckNumber='" + truckNumber + '\'' +
        ", spaceRequired=" + spaceRequired +
        '}';
  }
}
